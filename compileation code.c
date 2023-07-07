Compiletin Code
prog 1:-
1a :-  ex a1.c 
	  cc lex.yy.c -ll
	  ./a.out
1b :-  lex 1b.l
	  yacc -d 1b.y
	  cc lex.yy.c -ll

program 2:-
	same as above
program 3:-
	gcc 3.c
	./a.out
program 4,5:-
	gcc 4.c
	./a.out
program 6:-
	6a :- lex 6a.l
		gcc lex.yy.c -ll
		./a.out f1.c op.c
	6b :-same:

program 7,8,9:-
	gcc 6.c 
	./a.out