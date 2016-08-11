package com.rovio.elementizer;

import java.util.ArrayList;

public abstract class Elementizer {
	public static final String[] SYMBOLS={"H","He","Li","Be","B","C","N","O","F","Ne","Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn","Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe","Cs","Ba","La","Ce","Pr","Nd","Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb","Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Ac","Th","Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm","Md","No","Lr","Rf","Db","Sg","Bh","Hs","Mt","Ds","Rg","Cn","Uut","Fl","Uup","Lv","Uus","Uuo"};
	public static final int[] LENGTHS={1,2,2,2,1,1,1,1,1,2,2,2,2,2,1,1,2,2,1,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,2,3,2,3,3};
	public static final String[] NAMES={"Hydrogen ","Helium ","Lithium ","Beryllium ","Boron ","Carbon ","Nitrogen ","Oxygen ","Fluorine ","Neon ","Sodium ","Magnesium ","Aluminum ","Silicon ","Phosphorus ","Sulfur ","Chlorine ","Argon ","Potassium ","Calcium ","Scandium ","Titanium ","Vanadium ","Chromium ","Manganese ","Iron ","Cobalt ","Nickel ","Copper ","Zinc ","Gallium ","Germanium ","Arsenic ","Selenium ","Bromine ","Krypton ","Rubidium ","Strontium ","Yttrium ","Zirconium ","Niobium ","Molybdenum ","Technetium ","Ruthenium ","Rhodium ","Palladium ","Silver ","Cadmium ","Indium ","Tin ","Antimony ","Tellurium ","Iodine ","Xenon ","Cesium ","Barium ","Lanthanum ","Cerium ","Praseodymium ","Neodymium ","Promethium ","Samarium ","Europium ","Gadolinium ","Terbium ","Dysprosium ","Holmium ","Erbium ","Thulium ","Ytterbium ","Lutetium ","Hafnium ","Tantalum ","Tungsten ","Rhenium ","Osmium ","Iridium ","Platinum ","Gold ","Mercury ","Thallium ","Lead ","Bismuth ","Polonium ","Astatine ","Radon ","Francium ","Radium ","Actinium ","Thorium ","Protactinium ","Uranium ","Neptunium ","Plutonium ","Americium ","Curium ","Berkelium ","Californium ","Einsteinium ","Fermium ","Mendelevium ","Nobelium ","Lawrencium ","Rutherfordium ","Dubnium ","Seaborgium ","Bohrium ","Hassium ","Meitnerium ","Darmstadtium ","Roentgenium ","Copernicium ","Ununtrium ","Flerovium ","Ununpentium ","Livermorium ","Ununseptium ","Ununoctium"};

	public static int[] getElements(String str) {
		String strLocal=str.toLowerCase();
		ArrayList<Integer> out = new ArrayList<Integer>(0);
		recurseElements(out,strLocal,0);
		int[] outArr=new int[out.size()];
		for(int i=0;i<out.size();i++) outArr[i]=out.get(i);
		return outArr;
	}
	
	private static boolean recurseElements(ArrayList<Integer> currentSolution, String str, int depth) {
		if (str.length()==0) return true;
		for (int i=0;i<118;i++) {
			if (str.startsWith(SYMBOLS[i].toLowerCase())) {
				boolean temp = recurseElements(currentSolution,str.substring(LENGTHS[i]), depth+1);
				if (temp) {
					currentSolution.add(0, i);
					return true;
				}
			}
		}
		return false;
	}
	
	public static String getElementSymbols(String str) {
		int[] temp=getElements(str);
		if (temp.length==0) return "No possible combination of elements found.";
		String out="";
		for (int i:temp) out+=SYMBOLS[i];
		return out;
	}
	
	public static String getElementNames(String str) {
		int[] temp=getElements(str);
		String out="";
		for (int i:temp) out+=NAMES[i]+" ";
		return out;
	}
}
