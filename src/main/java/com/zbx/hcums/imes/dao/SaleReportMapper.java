package com.zbx.hcums.imes.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zbx.hcums.imes.entity.vo.SaleReportVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/22
 * @describe
 **/
@Mapper
public interface SaleReportMapper {

    // 区域销售排名
    List<SaleReportVo> regionalSale();

    // 省份销售额
    List<SaleReportVo> provinceSale();

    // 全年月份销售额
    List<SaleReportVo> yearOfMonthSale();

    // 订单品类销售额
    List<SaleReportVo> orderTypeSale();

    // 经销商销售排名
    List<SaleReportVo> dealerSale();

    // 本月销售额
    SaleReportVo thisMonthSale();

    // 今年销售额
    SaleReportVo thisYearSale();

    // 今日销售额
    SaleReportVo todaySale();

    // 上月销售额
    SaleReportVo lastMonthSale();

}
