package deel2.domain;

public abstract class Vorm implements Drawable{
	
	private boolean zichtbaar;
	
	public Vorm(){
		setZichtbaar(true);
	}

	public abstract Omhullende getOmhullende();
	
	@Override
	public String toString(){
		return " - "+this.getOmhullende().toString();
	}
	
	@Override
	public boolean equals(Object object){
		boolean gelijk = false;
		if(object instanceof Vorm){
			Vorm vorm = (Vorm)(object);
			if(vorm.getOmhullende().equals(this.getOmhullende())){
				gelijk = true;
			}
		}	
		return gelijk;
	}

	public void setZichtbaar(boolean zichtbaar) {
		this.zichtbaar = zichtbaar;		
	}
	
	public boolean isZichtbaar(){
		return zichtbaar;
	}
}
