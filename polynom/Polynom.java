package ru.span.polynom;
import java.lang.reflect.Array;

public class Polynom {
	protected double[] index ;
	
	public Polynom(){
		this.index = new double[1];
	}
	
	public Polynom(int stepen){
		this.index = new double[stepen+1];
	}
	
	public Polynom(double[] coef){
		this.index = coef;
	}
	

	
	@Override 
	public String toString(){
		this.nu();
		String rez = "";
        if(index.length == 1 || (index.length > 1 && index[0] != 0)) rez += index[0];
        for (int i = 1;i < index.length; i++){
            if(index[i] == 0) continue;
            if(index[i] > 0 && rez.length() != 0) rez += "+";
            if(index[i] != 1) rez += index[i];
            rez += "x";
            if(i != 1) rez += "^" + i;
        }
        return rez;
	}
	
	protected Polynom add(Polynom ad){
    	int max = ad.index.length;
    	if(index.length > ad.index.length){
    		max = index.length;
    	}
    	Polynom  rez = new Polynom(max-1);
    	for(int i = 0; i < index.length; i++){
    	rez.index[i] = index[i];
    	}
    	for(int i = 0; i < ad.index.length; i++){
        	rez.index[i] += ad.index[i];
        	}
    	return rez;
    	
    }
	
    protected Polynom add(double num){
    	Polynom rez = new Polynom(index.length-1);
    	rez.index[0] = index[0] + num;
    	for(int i = 1; i < index.length; i++)
    	rez.index[i] = index[i];
    	return rez;
    }
    
    protected Polynom sub(Polynom subs){
    	int max = subs.index.length;
    	if(index.length > subs.index.length){
    		max = index.length;
    	}
    	Polynom  rez = new Polynom(max-1);
    	for(int i = 0; i < index.length; i++){
    	rez.index[i] = index[i];
    	}
    	for(int i = 0; i < subs.index.length; i++){
        	rez.index[i] -= subs.index[i];
        	}
    	return rez;
    	
    }
    
    protected Polynom sub(double num){
    	Polynom rez = new Polynom(index.length-1);
    	rez.index[0] = index[0]-num;
    	for(int i = 1; i < index.length; i++)
    	rez.index[i] = index[i];
    	return rez;
    }
    
    protected Polynom divOnNum(double num){
    	if(num == 0) new Polynom(0);
    	Polynom rez = new Polynom(index.length - 1);
    	for(int i = 0; i < index.length; i++ ){
    		rez.index[i] = (double)index[i]/num;
    	}
    	return rez;
    }
    
    protected Polynom mult(Polynom mul){
    	int max = mul.index.length + index.length - 2;
    	Polynom rez = new  Polynom(max);
    	for(int i = mul.index.length - 1; i >= 0; i--){
    		for(int j = index.length - 1;j >= 0; j--){
    			rez.index[i+j] += index[j]*mul.index[i];
    		}
    	}
    	return rez;
    }
    
    protected Polynom mult(double num){
    	if(num == 0) new Polynom(0);
    	Polynom rez = new Polynom(index.length - 1);
    	for(int i = 0; i < index.length; i++ ){
    		rez.index[i] = (double)index[i]*num;
    	}
    	return rez;
    }
    
    public Polynom nu(){
    	int nu = 0;
    	for(int i = index.length - 1; i > 0; i--){
    		if(index[i] == 0){
    			nu++;
    		}
    		else{
    		break;
    		}
    	}
    	if(nu != 0){
    		double[] rez = new double[index.length - nu];
    		for(int j = 0;j < rez.length; j++ ){
    		rez[j] = index[j];
    			}
    			index = rez;
    	}
    	return this;
    }
    
    public double valInPoint(double x){
    	double f = 0;
    	for(int i = 0; i < index.length; i++){
    		f += index[i]*Math.pow(x,i);
    	}
    	return f;
    }
    
    private int deg(Polynom de){
    	int rez = de.index.length - 1;
    	return rez;
    }
   
}
   
