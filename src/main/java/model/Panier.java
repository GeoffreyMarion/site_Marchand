package model;

import java.util.ArrayList;

public class Panier {
	public ArrayList<Details_panier> produits = new ArrayList<>();

	public Panier(ArrayList<Details_panier> produits) {
		this.produits = produits;
	}

	public Panier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Panier [articles=" + produits + "]";
	}
	
	public int count() {
		return this.produits.size();
	}
	
	public void ajouter(Details_panier d) {
		boolean exist=false;
		for(Details_panier dp:produits) {
			if(dp.getProduit().getId_produit()==d.getProduit().getId_produit()) {
				exist=true;
				dp.setQte(dp.getQte()+d.getQte());
			}
		}
		if(exist==false) {
			produits.add(d);
		}
	}
	
	public String total() {
		double total=0;
		for(Details_panier dp:produits) {
			total+=dp.getProduit().getPrix()*dp.getQte();
		}
		return String.format("%.2f", total);
	}
	
	public void delete(int produitid) {
		Details_panier detail= new Details_panier();
		for(Details_panier pp:produits) {
			if(pp.getProduit().getId_produit()==produitid) {
				detail=pp;
			}
		}
		produits.remove(detail);
	}
	
	public void vider() {
		produits= new ArrayList<Details_panier>();
	}	
}
