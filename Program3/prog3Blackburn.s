	.section	__TEXT,__text,regular,pure_instructions
	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp2:
	.cfi_def_cfa_offset 16
Ltmp3:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp4:
	.cfi_def_cfa_register %rbp
	subq	$5320192, %rsp          ## imm = 0x512E00
	movq	___stack_chk_guard@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	movq	%rax, -8(%rbp)
	leaq	-104(%rbp), %rdi
	movabsq	$0, %rsi
	xorps	%xmm0, %xmm0
	movl	$0, -12(%rbp)
	movl	$0, -40(%rbp)
	movl	$0, -44(%rbp)
	movl	$0, -48(%rbp)
	movl	$0, -52(%rbp)
	movsd	%xmm0, -72(%rbp)
	movsd	%xmm0, -80(%rbp)
	movsd	%xmm0, -88(%rbp)
	callq	_gettimeofday
	movl	$0, -56(%rbp)
	movl	%eax, -5320132(%rbp)    ## 4-byte Spill
LBB0_1:                                 ## =>This Inner Loop Header: Depth=1
	cmpl	$5000, -56(%rbp)        ## imm = 0x1388
	jge	LBB0_4
## BB#2:                                ##   in Loop: Header=BB0_1 Depth=1
	leaq	-200128(%rbp), %rax
	movslq	-56(%rbp), %rcx
	imulq	$40, %rcx, %rcx
	addq	%rcx, %rax
	movl	36(%rax), %edx
	movl	%edx, -48(%rbp)
## BB#3:                                ##   in Loop: Header=BB0_1 Depth=1
	movl	-56(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -56(%rbp)
	jmp	LBB0_1
LBB0_4:
	leaq	L_.str(%rip), %rdi
	leaq	-120(%rbp), %rax
	xorl	%esi, %esi
	movq	%rdi, -5320144(%rbp)    ## 8-byte Spill
	movq	%rax, %rdi
	callq	_gettimeofday
	movl	-104(%rbp), %ecx
	imull	$1000000, %ecx, %ecx    ## imm = 0xF4240
	movl	%ecx, -24(%rbp)
	movl	-96(%rbp), %ecx
	movl	%ecx, -32(%rbp)
	movl	-24(%rbp), %edx
	addl	%ecx, %edx
	imull	$1000, %edx, %ecx       ## imm = 0x3E8
	movl	%ecx, -16(%rbp)
	movl	-120(%rbp), %ecx
	imull	$1000000, %ecx, %ecx    ## imm = 0xF4240
	movl	%ecx, -28(%rbp)
	movl	-112(%rbp), %ecx
	movl	%ecx, -36(%rbp)
	movl	-28(%rbp), %edx
	addl	%ecx, %edx
	imull	$1000, %edx, %ecx       ## imm = 0x3E8
	movl	%ecx, -20(%rbp)
	movl	-16(%rbp), %edx
	subl	%edx, %ecx
	movl	%ecx, -40(%rbp)
	movslq	%ecx, %rsi
	imulq	$1759218605, %rsi, %rsi ## imm = 0x68DB8BAD
	sarq	$43, %rsi
	movl	%esi, %ecx
	movl	%ecx, %edx
	shrl	$31, %edx
	addl	%edx, %ecx
	cvtsi2sdl	%ecx, %xmm0
	movsd	%xmm0, -72(%rbp)
	movq	-5320144(%rbp), %rdi    ## 8-byte Reload
	movl	%eax, -5320148(%rbp)    ## 4-byte Spill
	movb	$0, %al
	callq	_printf
	leaq	L_.str1(%rip), %rdi
	movsd	-72(%rbp), %xmm0
	movl	%eax, -5320152(%rbp)    ## 4-byte Spill
	movb	$1, %al
	callq	_printf
	leaq	-104(%rbp), %rdi
	movabsq	$0, %rsi
	movl	%eax, -5320156(%rbp)    ## 4-byte Spill
	callq	_gettimeofday
	movl	$0, -56(%rbp)
	movl	%eax, -5320160(%rbp)    ## 4-byte Spill
LBB0_5:                                 ## =>This Inner Loop Header: Depth=1
	cmpl	$5000, -56(%rbp)        ## imm = 0x1388
	jge	LBB0_8
## BB#6:                                ##   in Loop: Header=BB0_5 Depth=1
	leaq	-5320128(%rbp), %rax
	movslq	-56(%rbp), %rcx
	shlq	$10, %rcx
	addq	%rcx, %rax
	movl	1020(%rax), %edx
	movl	%edx, -52(%rbp)
## BB#7:                                ##   in Loop: Header=BB0_5 Depth=1
	movl	-56(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -56(%rbp)
	jmp	LBB0_5
LBB0_8:
	leaq	L_.str(%rip), %rdi
	leaq	-120(%rbp), %rax
	xorl	%esi, %esi
	movq	%rdi, -5320168(%rbp)    ## 8-byte Spill
	movq	%rax, %rdi
	callq	_gettimeofday
	movl	-104(%rbp), %ecx
	imull	$1000000, %ecx, %ecx    ## imm = 0xF4240
	movl	%ecx, -24(%rbp)
	movl	-96(%rbp), %ecx
	movl	%ecx, -32(%rbp)
	movl	-24(%rbp), %edx
	addl	%ecx, %edx
	imull	$1000, %edx, %ecx       ## imm = 0x3E8
	movl	%ecx, -16(%rbp)
	movl	-120(%rbp), %ecx
	imull	$1000000, %ecx, %ecx    ## imm = 0xF4240
	movl	%ecx, -28(%rbp)
	movl	-112(%rbp), %ecx
	movl	%ecx, -36(%rbp)
	movl	-28(%rbp), %edx
	addl	%ecx, %edx
	imull	$1000, %edx, %ecx       ## imm = 0x3E8
	movl	%ecx, -20(%rbp)
	movl	-16(%rbp), %edx
	subl	%edx, %ecx
	movl	%ecx, -44(%rbp)
	movslq	%ecx, %rsi
	imulq	$1759218605, %rsi, %rsi ## imm = 0x68DB8BAD
	sarq	$43, %rsi
	movl	%esi, %ecx
	movl	%ecx, %edx
	shrl	$31, %edx
	addl	%edx, %ecx
	cvtsi2sdl	%ecx, %xmm0
	movsd	%xmm0, -80(%rbp)
	movq	-5320168(%rbp), %rdi    ## 8-byte Reload
	movl	%eax, -5320172(%rbp)    ## 4-byte Spill
	movb	$0, %al
	callq	_printf
	leaq	L_.str2(%rip), %rdi
	movsd	-80(%rbp), %xmm0
	movl	%eax, -5320176(%rbp)    ## 4-byte Spill
	movb	$1, %al
	callq	_printf
	leaq	L_.str(%rip), %rdi
	movl	%eax, -5320180(%rbp)    ## 4-byte Spill
	movb	$0, %al
	callq	_printf
	movl	$1, -60(%rbp)
	movl	%eax, -5320184(%rbp)    ## 4-byte Spill
LBB0_9:                                 ## =>This Inner Loop Header: Depth=1
	cmpl	$512, -60(%rbp)         ## imm = 0x200
	jge	LBB0_11
## BB#10:                               ##   in Loop: Header=BB0_9 Depth=1
	movl	-60(%rbp), %edi
	callq	_timing
	leaq	L_.str3(%rip), %rdi
	movsd	%xmm0, -88(%rbp)
	movl	-60(%rbp), %esi
	movsd	-88(%rbp), %xmm0
	movb	$1, %al
	callq	_printf
	movl	-60(%rbp), %esi
	shll	$1, %esi
	movl	%esi, -60(%rbp)
	movl	%eax, -5320188(%rbp)    ## 4-byte Spill
	jmp	LBB0_9
LBB0_11:
	movq	___stack_chk_guard@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	movq	-8(%rbp), %rcx
	cmpq	%rcx, %rax
	jne	LBB0_13
## BB#12:                               ## %SP_return
	movl	$0, %eax
	addq	$5320192, %rsp          ## imm = 0x512E00
	popq	%rbp
	ret
LBB0_13:                                ## %CallStackCheckFailBlk
	callq	___stack_chk_fail
	.cfi_endproc

	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	 "\n"

L_.str1:                                ## @.str1
	.asciz	 "Average access time for array1 = %f ns\n"

L_.str2:                                ## @.str2
	.asciz	 "Average access time for array2 = %f ns\n"

L_.str3:                                ## @.str3
	.asciz	 "Avg time for %d = %f ns\n"


.subsections_via_symbols
