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
        return calculatePearsonCorrelationCoef(squareList, priceList, priceList.size());
    }

    public Double calculatePearsonCorrelationCoef(List<Integer> x, List<Integer> y, int n) {
        int sumX = 0, sumY = 0, sumXY = 0;
        int squareSumX = 0, squareSumY = 0;
        double correlation;
        for (int i = 0; i < n; i++) {
            sumX += x.get(i);
            sumY += y.get(i);
            sumXY += x.get(i) * y.get(i);
            squareSumX += x.get(i) * x.get(i);
            squareSumY += y.get(i) * y.get(i);
        }
        correlation = (n * sumXY - sumX * sumY) /
                (Math.sqrt((n * squareSumX -
                        sumX * sumX) * (n * squareSumY -
                        sumY * sumY)));


        double []doubleX = new double[x.size()];
        double []doubleY = new double[y.size()];
        for (int i = 0; i < n; i++) {
            doubleX[i]= x.get(i);
            doubleY[i]=y.get(i);
        }
        return getPearsonCorrelation(doubleX,doubleY);

    }

    public double getPearsonCorrelation(double[] x, double[] y) {
        PearsonsCorrelation correlation = new PearsonsCorrelation();
        return correlation.correlation(x, y);
    }
}
