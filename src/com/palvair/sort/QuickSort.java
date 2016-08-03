package com.palvair.sort;

import java.util.Arrays;

public class QuickSort {

	public static int[] tab = {101,115,30,63,47};
	
	public static void main(String[] args) {
		quicksort(tab, 0,4);
		System.out.println("tab = "+Arrays.toString(tab));
	}
	

	
	public static void quicksort(int [] tableau, int début, int fin) {
	    if (début < fin) {
	        int indicePivot = partition(tableau, début, fin);
	        quicksort(tableau, début, indicePivot-1);
	        quicksort(tableau, indicePivot+1, fin);
	    }
	}

	public static int partition (int [] t, int début, int fin) {
	    //choix pivot au début
		int valeurPivot = t[début];
	    int gauche = début+1;
	    int droite = fin;
	    //on s'arrête quand gauche = droite donc quand il y a chevauchement
	    while (gauche < droite) {
	    	//positionne les éléments inférieurs au pivot à gauche et les éléments supérieurs au pivot à droite
	        while(gauche < droite && t[droite] >= valeurPivot) droite--;
	        while(gauche < droite && t[gauche] <= valeurPivot) gauche++;

	        //permutation
	        //ça ne sert à rien de permuter si gauche et droite pointe vers le même élément
	        if(gauche != droite) {
	        	t = permut(t, gauche, droite);
	        }
	        
	    }
	    //je teste l'élément courant de la partie gauche donc juste après le pivot si je n'ai pas avancé
	    if (t[gauche] > valeurPivot) gauche--; //ici je trouve un élément inférieur au pivot ou le pivot lui-même
	    t[début] = t[gauche]; //positionne l'élément courant(le plus petit élément) au début du tableau
	    t[gauche] = valeurPivot; //déplace le pivot à la place de l'élément courant
	    return gauche;
	}
	
	public static int[] permut(int[] tab,int gauche, int droite) {
		int temp = tab[gauche];
		tab[gauche] = tab[droite];
		tab[droite] = temp;
		return tab;
	}
}
