package pojo;

import java.util.List;

public class Features<T> {
	private long featureId;
	private String typeOfFeature;
	private int label;
	private List<T> values;
	private T aggValues;
	
	public String getTypeOfFeature() {
		return typeOfFeature;
	}
	public void setTypeOfFeature(String typeOfFeature) {
		this.typeOfFeature = typeOfFeature;
	}
	public int getLabel() {
		return label;
	}
	public void setLabel(int label) {
		this.label = label;
	}
	public List<T> getValues() {
		return values;
	}
	public void setValues(List<T> values) {
		this.values = values;
	}
	public T getAggValues() {
		return aggValues;
	}
	public void setAggValues(T aggValues) {
		this.aggValues = aggValues;
	}	
	
	@Override
	public String toString() {
		return "Features [typeOfFeature=" + typeOfFeature + ", label=" + label + ", values=" + values + ", aggValues="
				+ aggValues + "]";
	}
	
}
