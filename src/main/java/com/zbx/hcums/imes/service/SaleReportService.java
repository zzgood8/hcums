package com.zbx.hcums.imes.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zbx.hcums.imes.dao.SaleReportMapper;
import com.zbx.hcums.imes.entity.vo.SaleReportVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/22
 * @describe
 **/
@DS("imes")
@Service
public class SaleReportService {

    private final SaleReportMapper saleReportMapper;

    SaleReportService(SaleReportMapper saleReportMapper) {
        this.saleReportMapper = saleReportMapper;
    }

    // 区域销售排名
    public List<SaleReportVo> regionalSale() {
        return saleReportMapper.regionalSale();
    }

    // 省份销售额
    public List<SaleReportVo> provinceSale() {
        return saleReportMapper.provinceSale();
    }

    // 全年月份销售额
    public List<SaleReportVo> yearOfMonthSale() {
        return saleReportMapper.yearOfMonthSale();
    }

    // 订单品类销售额
    public List<SaleReportVo> orderTypeSale() {
        return saleReportMapper.orderTypeSale();
    }

    // 经销商销售排名
    public List<SaleReportVo> dealerSale() {
        return saleReportMapper.dealerSale();
    }

    // 本月销售额
    public SaleReportVo thisMonthSale() {
        return saleReportMapper.thisMonthSale();
    }

    // 今年销售额
    public SaleReportVo thisYearSale() {
        return saleReportMapper.thisYearSale();
    }

    // 今日销售额
    public SaleReportVo todaySale() {
        return saleReportMapper.todaySale();
    }

    // 上月销售额
    public SaleReportVo lastMonthSale() {
        return saleReportMapper.lastMonthSale();
    }

}
