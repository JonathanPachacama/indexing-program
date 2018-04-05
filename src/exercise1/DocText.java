package exercise1;

public class DocText {
	
	 private int frecuencia;
	    private String palabra;
	    private String listDocs;

	    public DocText() {
	        this.frecuencia = 0;
	        this.listDocs = " ";
	    }

	    public String getListDocs() {
	        return listDocs;
	    }

	    public void setListDocs(String listDocs) {
	        this.listDocs = listDocs;
	    }

	    public int getFrecuencia() {
	        return frecuencia;
	    }

	    public void setFrecuencia(int frecuencia) {
	        this.frecuencia = frecuencia;
	    }

	    public String getPalabra() {
	        return palabra;
	    }

	    public void setPalabra(String palabra) {
	        this.palabra = palabra;
	    }

}

