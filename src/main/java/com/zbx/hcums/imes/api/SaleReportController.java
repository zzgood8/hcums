package com.zbx.hcums.imes.api;

import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.imes.entity.vo.SaleReportVo;
import com.zbx.hcums.imes.service.SaleReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/22
 * @describe
 **/
@RestController
@RequestMapping("/imes/saleReport")
public class SaleReportController {

    private final SaleReportService saleReportService;

    SaleReportController(SaleReportService saleReportService) {
        this.saleReportService = saleReportService;
    }

    // 区域销售排名
    @GetMapping("/regionalSale")
    public Result<List<SaleReportVo>> regionalSale() {
        List<SaleReportVo> list = saleReportService.regionalSale();
        return Result.success(list);
    }

    // 省份销售额
    @GetMapping("/provinceSale")
    public Result<List<SaleReportVo>> provinceSale() {
        return Result.success(saleReportService.provinceSale());
    }

    // 全年月份销售额
    @GetMapping("/yearOfMonthSale")
    public Result<List<SaleReportVo>> yearOfMonthSale() {
        return Result.success(saleReportService.yearOfMonthSale());
    }

    // 订单品类销售额
    @GetMapping("/orderTypeSale")
    public Result<List<SaleReportVo>> orderTypeSale() {
        return Result.success(saleReportService.orderTypeSale());
    }

    // 经销商销售排名
    @GetMapping("/dealerSale")
    public Result<List<SaleReportVo>> dealerSale() {
        return Result.success(saleReportService.dealerSale());
    }

    // 本月销售额
    @GetMapping("/thisMonthSale")
    public Result<SaleReportVo> thisMonthSale() {
        return Result.success(saleReportService.thisMonthSale());
    }

    // 今年销售额
    @GetMapping("/thisYearSale")
    public Result<SaleReportVo> thisYearSale() {
        return Result.success(saleReportService.thisYearSale());
    }

    // 今日销售额
    @GetMapping("/todaySale")
    public Result<SaleReportVo> todaySale() {
        return Result.success(saleReportService.todaySale());
    }

    // 上月销售额
    @GetMapping("/lastMonthSale")
    public Result<SaleReportVo> lastMonthSale() {
        return Result.success(saleReportService.lastMonthSale());
    }
}
