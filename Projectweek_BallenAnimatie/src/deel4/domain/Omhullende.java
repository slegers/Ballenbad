package deel4.domain;

public class Omhullende {

	private Punt positie;
	private int breedte;
	private int hoogte;

	public Omhullende(Punt positieLinksBoven, int breedte, int hoogte)
			throws IllegalArgumentException {
		setPositie(positieLinksBoven);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

	public Punt getPositie() {
		return positie;
	}

	private void setPositie(Punt positieLinksBoven)
			throws IllegalArgumentException {
		if (positieLinksBoven == null) {
			throw new IllegalArgumentException(
					"positieLinksBoven mag niet null zijn");
		}
		this.positie = positieLinksBoven;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) throws IllegalArgumentException {
		if (hoogte < 0) {
			throw new IllegalArgumentException("hoogte kan niet negatief zijn");
		}
		this.hoogte = hoogte;
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) throws IllegalArgumentException {
		if (breedte < 0) {
			throw new IllegalArgumentException("breedte kan niet negatief zijn");
		}
		this.breedte = breedte;
	}

	public int getMinX() {
		return getPositie().getX();
	}

	public int getMinY() {
		return getPositie().getY();
	}

	public int getMaxX() {
		return getPositie().getX() + getBreedte();
	}

	public int getMaxY() {
		return getPositie().getY() + getHoogte();
	}

	@Override
	public boolean equals(Object object) {
		boolean gelijk = false;
		if (object instanceof Omhullende) {
			Omhullende omhullende = (Omhullende) (object);
			if (omhullende.getPositie().equals(this.getPositie())
				&& omhullende.getBreedte() == this.getBreedte()
				&& omhullende.getHoogte() == this.getHoogte()) {
				gelijk = true;
			}
		}
		return gelijk;
	}

	@Override
	public String toString() {
		return "Omhullende: " + positie.toString() + " - " + getBreedte()
				+ " - " + getHoogte();
	}

}
