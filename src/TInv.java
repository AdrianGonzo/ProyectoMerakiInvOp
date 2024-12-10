
public class TInv {
	private double k;
	private double c;
	private double h;
	private double d;
	private double l;
	public TInv(double k, double c, double h, double d, double l) {
		this.k = k;
		this.c = c;
		this.h = h;
		this.d = d;
		this.l = l;
	}
	
	public double cantOptimaPedido()
	{
		double q = Math.sqrt((2*this.d*this.k)/(this.h));
		return q;
	}
	public double tiempoCicloProduccion()
	{
		double q = cantOptimaPedido();
		double t = (q)/(this.d);
		return t;
	}
	public double numCiclosTiempo()
	{
		double q = cantOptimaPedido();
		double n = (this.d)/(q);
		return n;
	}
	public double costoTotalTiempo()
	{
		double q = cantOptimaPedido();
		double aux1=(this.d*this.k)/(q);
		double aux2=this.d*this.c;
		double aux3=(this.h*q)/(2);
		double ctt = aux1+aux2+aux3;
		return ctt;
	}
	public double costoTotalCiclo()
	{
		double q = cantOptimaPedido();
		double aux1 = this.c*q;
		double aux2 = (this.h*(Math.pow(q, 2)))/(2*(this.d));
		double ctcl = this.k+aux1+aux2;
		return ctcl;
	}
	public double puntoReorden()
	{
		double n = Math.floor((this.l)/tiempoCicloProduccion());
		double le = this.l-(n*tiempoCicloProduccion());
		double r = le*this.d;
		return r;
	}
	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}
	
}
