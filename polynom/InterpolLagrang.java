package ru.span.polynom;
import java.util.HashMap;
import java.util.Map;

public class InterpolLagrang extends Polynom {
	private double[] nodes;
	private double[] value;
		
	public InterpolLagrang(){}
	
	
	public InterpolLagrang(double []nodes, double[]value){
		this.hashM(nodes, value);
        l_n(this.nodes,this.value);
	}

	private Polynom l_k(int k){
		Polynom l_k = new Polynom(new double[]{1});
		for(int i=0; i<nodes.length; i++){
			if(i==k)continue;
			Polynom m=new Polynom(new double[]{-nodes[i],1});
			l_k=l_k.mult(m);
		    l_k=l_k.divOnNum(nodes[k]-nodes[i]);
		}
		return l_k;
	}
	public Polynom l_n(double[] nodes, double[] value) {
		this.hashM(nodes, value);
		Polynom rez = new Polynom(new double[]{0});
		for(int i=0; i<this.nodes.length; i++){
			rez=rez.add(this.l_k(i).mult(this.value[i]));
		}
		index = rez.index.clone();
		return rez;
	}
	 private void hashM(double[] nodes, double[] value){
    	 HashMap<Double,Double> hashMap=new HashMap<Double, Double>();
         for(int i=0;i< nodes.length;i++){
             if(hashMap.containsKey(nodes[i]))continue;
             hashMap.put(nodes[i],value[i]);
         }
         
         this.nodes=new double[hashMap.size()];
         this.value=new double[hashMap.size()];
         int k=0;
         for (Map.Entry entry : hashMap.entrySet()) {
        	    this.nodes[k]=(double) entry.getKey();
        	    this.value[k]=(double) entry.getValue();
        	    k++;
        	} 
	 }
}
