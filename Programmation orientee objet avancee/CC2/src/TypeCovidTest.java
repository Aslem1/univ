public enum TypeCovidTest {
	RT_PCR(100),
	ANTIGENIQUE(71),
	SALIVAIRE(82),
	SEROLOGIQUE(90);
	
	private int fiabilite;

	private TypeCovidTest(int fiabilite) {
		this.fiabilite = fiabilite;
	}
	
	public int donneFiabilite() {
		return fiabilite;
	}
	
}
