package com.nuriza.fqw.fqw.services.impl;

import com.nuriza.fqw.fqw.services.*;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CorrelationServiceImpl implements CorrelationService {
    private BatirService batirService;
    private ClientService clientService;
    private EmployeeService employeeService;
    private KurulushService kurulushService;


    public CorrelationServiceImpl(BatirService batirService,
                                  ClientService clientService,
                                  EmployeeService employeeService,
                                  KurulushService kurulushService) {
        this.batirService = batirService;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.kurulushService = kurulushService;
    }

    public Double getCorrelationBatir() {
        List<Integer> squareList = batirService.getSquares();
        List<Integer> priceList = batirService.getPrices();
        return calculatePearsonCorrelationCoef(squareList, priceList);
    }

    public Double calculatePearsonCorrelationCoef(List<Integer> xs, List<Integer> ys) {
        double sx = 0.0;
        double sy = 0.0;
        double sxx = 0.0;
        double syy = 0.0;
        double sxy = 0.0;

        int n = xs.size();
        for (int i = 0; i < n; ++i) {
            int x = xs.get(i);
            double y = ys.get(i);

            sx += x;
            sy += y;
            sxx += x * x;
            syy += y * y;
            sxy += x * y;
        }
        double cov = sxy / n - sx * sy / n / n;
        double sigmax = Math.sqrt(sxx / n - sx * sx / n / n);
        double sigmay = Math.sqrt(syy / n - sy * sy / n / n);

        return cov / sigmax / sigmay;

    }

    public double getPearsonCorrelation(double[] x, double[] y) {
        PearsonsCorrelation correlation = new PearsonsCorrelation();
        return correlation.correlation(x, y);
    }
}
