package it.polito.tdp.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		model.setListe(model.anagramma("cane"));
		System.out.println("PAROLE GIUSTE");
		System.out.println(model.getParoleGiuste().toString());
		System.out.println("\n\n\n\n\n");
		System.out.println("PAROLE SBAGLIATE");
		System.out.println(model.getParoleSbagliate().toString());
	}

}
