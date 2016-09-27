# include <stdio.h>
# include <conio.h>
void fun1(int, int, int);
void fun2(int, int, int);
int main()
{
	int a, b, c;
	a = 10;
	b = 20;
	c = 30;
	while(b) {
		b--;
	}
	fun1(a, b, c);
	fun2(a, b, c);
	return 0;
}
void fun1(int a, int b, int c)
{
	if(a > b && c > b)
	{
		if(a)
		{
			printf(, a);
		}
		else
		{
			printf(, c);
		}
	}
	else
	{
		if(b > c)
		{
			printf(, b);
		}
		else
		{
			printf(, c);
		}
	}
}
void fun2(int a, int b, int c)
{
	if(a == 354)
	{
		if(b > c)
		{
			a = b;
		}
		else
		{
			a = c;
		}
	}
	printf(, a);
}

