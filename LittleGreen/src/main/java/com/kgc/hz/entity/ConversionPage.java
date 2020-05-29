package com.kgc.hz.entity;

import java.util.List;

public class ConversionPage extends Page {
    private List<Conversion> ConversionList;

    public List<Conversion> getConversionList() {
        return ConversionList;
    }

    public void setConversionList(List<Conversion> conversionList) {
        ConversionList = conversionList;
    }
}
