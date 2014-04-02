/**
 * mutex - simple mutex example
 * Original Author: alex Sayle <alexs@cse>
 * Modified:  Leclerc
 * Modified_2: Michael Blackburn
 * Added mutex and condition pointer attributes to the struct 
 * thread_args for pointers to access in function print_ident, 
 * and used those pointers for lock/unlock and in signaling
 * for thread synchronization.s 
 *
 */
#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>

// The number of thread that will be started
#define THREAD_COUNT 10 
// sleeping factor 
#define N 5
//define counter globally
int counter ;
//define mutex gloablly
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER ;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER ;

/*
 * argument given to the thread
 *
 */
struct thread_args {
  int ident ;                 // theads identity
  int * global_counter ;      // global counter 
  pthread_cond_t * condPtr ;
  pthread_mutex_t * mutexPtr ;
  // add argument that you want to pass to threads
};

// type def for those who don't like writing struct all the time 
typedef struct thread_args  thread_args_t ;

// forward declaration of function(s)
void print_ident(thread_args_t *args);

/*
 *  Main code
 */
int main(int argc, char** argv)
{

  pthread_t        worker[THREAD_COUNT + 1] ;  // threads
  thread_args_t    args[THREAD_COUNT + 1];     // thread arguments
  int i ; 
  long *statusp  ;  
  //pthread_cond_init cond(&cond, NULL) ;                       

  // hint:: you may need to use a mutex.
  //pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER ;
  counter = 0;
  printf("Mutex program starting. \n");

  /* Set evil seed (initial seed) */
  srand( (unsigned)time( NULL ) );


  /*
   * start up threads
   */
  for(i=1;i<=THREAD_COUNT;i++){

    /* Set up argument */
    args[i].ident = i  ;
    args[i].global_counter = &counter;
    args[i].condPtr = &cond;
    args[i].mutexPtr = &mutex;
	
    // set any other argument you want to pass to the 
    // newly created thread
    pthread_create(&worker[i],
		   NULL,
		   (void *) print_ident,
		   (void *) &args[i]) ;
  }

  /* sleep for 60 secs before cleaning up*/
  sleep(60);

  /*
   * cleaning up after threads
   */
  for(i=1;i<=THREAD_COUNT;i++){
    /* just in case the thread returns, make sure we handle it */
    pthread_join(worker[i],(void *)&statusp);
    if(PTHREAD_CANCELED == statusp ){
      printf("thread %d was canceld\n",args[i].ident);
    } else{
      fprintf(stderr, "thread %d completed. it's return value isf %ld\n",
	      args[i].ident,*statusp);
    }
  }
  /* and we're done */
  return(0);
}


/**
 * this function is started as a new thread.
 *
 */
void print_ident(thread_args_t *args){
  int s;
 
  /* say hello to the world. */
  printf("Hello world, I'm thread %d\n",args->ident);

    
  for(;;){
	
    /*
     *  sleep for a random time to make thing random. 
     */
    s =1+(int) (N * ((double) rand() / (double)(RAND_MAX + 1.0))) ;
    sleep(s);

    /*
     * up date the global counter and start go back to sleep.
     *
     * you need to add some code here so that threads obey their
     * order in the queue.
     *
     */
    {
      pthread_mutex_lock(args->mutexPtr);
      while(args->ident - 1 != (*args->global_counter) % THREAD_COUNT){
        pthread_cond_wait(args->condPtr, args->mutexPtr);
      }
      *args->global_counter +=1;
      printf("thread %2d  counting  %2d\n",
	    args->ident,*args->global_counter);
      pthread_cond_broadcast(args->condPtr);
      pthread_mutex_unlock(args->mutexPtr);
    }
  }
  /* should never happen */
  fprintf(stderr,"I'm returning.. [%d]\n",args->ident);
}
