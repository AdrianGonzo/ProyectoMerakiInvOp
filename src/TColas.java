
public class TColas 
{
	private double lambda;
	private double miu;
	private int s;
	public TColas(double lamda, double miu, int s) {
		this.lambda = lamda;
		this.miu = miu;
		this.s = s;
	}
	public double factorUtilizacion()
	{
		double rho=0;
		rho=(this.lambda)/(this.s*this.miu);
		return rho;
	}
	public double probabilidadCero()
	{
		double p0=0.0;
		if (this.s==0)
		{
			p0=(1-factorUtilizacion());
		}
		else if (this.s>0)
		{
			double sum = 0;
			for (int i=0; i<=this.s-1;i++)
			{
				double iter = (Math.pow((this.lambda/this.miu), i))/(factorial(i));
				sum = sum+iter;
			}
			double aux1=(Math.pow((this.lambda/this.miu), Double.valueOf(this.s)))/(Double.valueOf(factorial(this.s)));
			double aux2=(1)/(1-factorUtilizacion());
			p0=(1)/((sum)+(aux1*aux2));
		}
		return p0;
		
	}
	public double probabilidadN(int n)
	{
		double rho = factorUtilizacion();
		double p0 = probabilidadCero();
		double pn=0;
		if (this.s==0)
		{
			pn=(Math.pow(rho, n))*(p0);
		}
		else if (this.s>0)
		{
			if (n>=0 && n<=this.s)
			{
				pn=(Math.pow((this.lambda/this.miu),n)*p0)/(Double.valueOf(factorial(n)));
			}
			else if (n>this.s)
			{
				pn=(Math.pow((this.lambda/this.miu),n)*p0)/(Double.valueOf(factorial(this.s))*Math.pow(this.s, n-this.s));
			}
		}
		return pn;
	}
	public double cantCliSis()
	{
		double ls = 0;
		if (this.s==0)
		{
			ls = (this.lambda)/(this.miu-this.lambda);
		}
		else if (this.s>0) 
		{
			ls = (cantCliCola())+((this.lambda)/(this.miu));
		}
		return ls;
	}
	public double cantCliCola()
	{
		double lq=0;
		if (this.s==0)
		{
			lq = (Math.pow(this.lambda, 2))/(this.miu*(this.miu-this.lambda));
		}
		else if (this.s>0)
		{
			double p0=probabilidadCero();
			double rho=factorUtilizacion();
			lq = (p0*Math.pow((this.lambda/this.miu), Double.valueOf(this.s))*rho)/(Double.valueOf(factorial(this.s))*Math.pow((1-rho), 2));
		}
		return lq;
	}
	public double tiempoEsperaSis()
	{
		double ws = 0;
		if (this.s==0)
		{
			ws = (1)/(this.miu-this.lambda);
		}
		else if (this.s>0)
		{
			ws = ((cantCliCola())/(this.lambda))+((1)/(this.miu));
		}
		return ws;
	}
	public double tiempoEsperaCola()
	{
		double wq=0;
		if (this.s==0)
		{
			wq = (this.lambda)/(this.miu*(this.miu-this.lambda));
		}
		else if (this.s>0)
		{
			wq = (cantCliCola())/(this.lambda);
		}
		return wq;
	}
	public double probabilidadEsperaSis(double t)
	{
		double rho = factorUtilizacion();
		double pWs = Math.pow(Math.E, (-(this.miu)*(1-rho)*(t)));
		return pWs;
	}
	public double probabilidadEsperaCola(double t)
	{
		double rho = factorUtilizacion();
		double pWq = rho*Math.pow(Math.E, (-(this.miu)*(1-rho)*(t)));
		return pWq;
	}
	
	public double getLamda() {
		return lambda;
	}
	public void setLamda(double lamda) {
		this.lambda = lamda;
	}
	public double getMiu() {
		return miu;
	}
	public void setMiu(double miu) {
		this.miu = miu;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	public int factorial(int n)
	{
		if (n==0)
		{
			return 1;
		}
		else
		{
			int fact = 1;
			for (int i=1;i<=n;i++)
			{
				fact=fact*i;
			}
			return fact;
		}
	}
}
