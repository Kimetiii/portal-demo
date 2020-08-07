package com.example.portalback.common.config;


import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EasyExcelLocalDateConverter implements Converter<LocalDate> {

    @Override
    public Class<LocalDate> supportJavaTypeKey() {
        return LocalDate.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public LocalDate convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) {
        return LocalDate.parse(cellData.getStringValue(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }

    @Override
    public CellData<String> convertToExcelData(LocalDate value, ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) {
        return new CellData<>(value.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
    }

}
