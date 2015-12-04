package pojo;

import java.util.List;

public class Features {
	private long featureId;
	private String typeOfFeature;
	private int label;
	private List<Object> values;
	private Object aggValues;
	
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
	public List<Object> getValues() {
		return values;
	}
	public void setValues(List<Object> values) {
		this.values = values;
	}
	public Object getAggValues() {
		return aggValues;
	}
	public void setAggValues(Object aggValues) {
		this.aggValues = aggValues;
	}	
	
	@Override
	public String toString() {
		return "Features [typeOfFeature=" + typeOfFeature + ", label=" + label + ", values=" + values + ", aggValues="
				+ aggValues + "]";
	}
	
}
