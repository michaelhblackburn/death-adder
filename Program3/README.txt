/*
 *README.txt
 *Michael Blackburn
 *CSCI 340
 *Program 3
 */

The idea behind this program is to use loops through arrays to ascertain the access speeds of both
cache and main memory. The first loop in main() uses an integer array with only 10 elements per row,
making this small enough for guaranteed cache hits on each iteration. This is repeated 5000 times, 
giving us consistent access times for cache memory in the tens of nanoseconds while running on stono
(about 20ns for this example).Readings on this local machine were inconsistent, and sometimes 
provided no results at all. The only explanation that I have for these results is that something 
must be unique to the way this program runs on this hardware and under OS X (UNIX based), versus 
the consistent results under stono.

The second loop used an integer array with 256 elements, a size large enough that it should guarantee
that accessing it goes out to main memory. Indeed, under stono, repeating the access 5000 times, we 
see times in the hundreds of nanosconds, averaging about 400ns for this particular example. Again,
results were sometimes wildly inconsistent on this local machine, and consistent experimentation was
performed under stono. This size could be further reduced by reducing the szie fo the array, giving 
us a slightly more accurate reading of access times for main memory; however, we do see that there 
exists a significant difference between cache and main memory - tens versus hundreds of nanoseconds. 

The next goals of this assignment were to ascertain cache line and total cache size. utilizing a one-
dimensional array and incrementally increasing "jumps" in the array by a power of 2 through each 
iteration - that is, the first time through, we access each element, then the next trip accesses 
every other element, then every fourth element, etc., until we see a time shift increase that will 
signify a jump from access in cache to access in main memory. Utilizing this approach yields somewhat 
consistent results, though not reliably so - even in stono. It is possible to sort the access times
and obtain a median result over multiple experiments, though that approach was not taken here. Under
direct observation over multiple runs, we see a consistent indication that the line size for cache
on stono is 64B (16 x 4 under this experiment). A similar approach is utilized to determine the cache 
size, but results were inconsistent, even on stono. Some experiments gave an indication that cache 
size is 32KB, but results were largely inconsistent, more than likely due to a logic error in code. 