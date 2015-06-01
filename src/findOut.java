public class findOut
{

	double getAns(String expression)
	{
		return SyntacticAnalysis(chrModify(expression));
	}

	double numModify(char[] chrBuf,int BufIndex)
	{
		double value = 0;
		int Exp = BufIndex;
		int chrBufdot = -1;

		for(int i = 0; i < BufIndex; i++) if(chrBuf[i] =='.') chrBufdot = i;

		if(chrBufdot != -1)
		{
			Exp = chrBufdot;
			BufIndex = BufIndex - 1;
			for(int i = chrBufdot; i < BufIndex; i++) chrBuf[i] = chrBuf[i+1];

		}

		for(int i = 0; i < BufIndex; i++)
		{
			--Exp;
			value += Math.pow(10, Exp) * Double.parseDouble("" + chrBuf[i]);
		}
		return value;
	}

	char[] chrModify(String strExpression)
	{
		char[] chrExpression = new char[strExpression.length()];

		for(int i = 0;i < strExpression.length();i++)
		{
			chrExpression[i] = strExpression.charAt(i);
		}

		return chrExpression;
	}

	double SyntacticAnalysis(char[] chrExpression)
	{
		double term,t1,ans;
		char[] Buf = new char[chrExpression.length-1];
		char operator ='n';
		int BufIndex = 0;
		term = t1 = ans = 0;

		for(int i = 0; i < chrExpression.length; i++)
		{
			if(chrExpression[i] == '+' || chrExpression[i] == '-' ||
					chrExpression[i] == '*' || chrExpression[i] == '/' || chrExpression[i] == '=')
			{
				term = numModify(Buf,BufIndex);
				BufIndex = 0;
			}

			switch(chrExpression[i])
			{
				case '=' :
					if(operator == 'n')
						ans += term;
					else
						ans += calc(t1,term,operator);
					break;
				case '+' :
					if(operator == 'n')
						ans += term;
					else
					{
						ans += calc(t1,term,operator);
						operator = 'n';
					}
					break;
				case '-' :
					if(operator == 'n')
						ans += term;
					else
					{
						ans += calc(t1,term,operator);
						operator = 'n';
					}
					t1 = -1;
					operator = '*';
					break;
				case '*' :
					if(operator == 'n')
						t1 = term;
					else
						t1 = calc(t1,term,operator);
					operator = '*';
					break;
				case '/' :
					if(operator == 'n')
						t1 = term;
					else
						t1 = calc(t1,term,operator);
					operator = '/';
					break;
				default:
					Buf[BufIndex] = chrExpression[i];
					BufIndex++;
					break;
			}
		}
		return ans;
	}

	double calc(double num1,double num2,char ope)
	{
		try
		{
			switch(ope)
			{
			case '+':
				return num1 + num2;
			case '-':
				return num1 - num2;
			case '*':
				return num1 * num2;
			case '/':
				return num1 / num2;
			default :
				return 0;
			}
		}
		catch(ArithmeticException e)
		{
			return 0;
		}
	}
}
