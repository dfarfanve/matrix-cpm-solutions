package com.download.service;

import com.download.model.Parameter;
import com.download.model.Property;
import com.download.model.Url;
import com.download.provecomer.ProvecomerUtil;
import com.download.util.ErrorCode;
import com.download.util.JSonUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.download.repository.ParameterRepo;
import com.download.repository.PropertyRepo;
import com.download.repository.UrlRepo;
import com.download.repository.UserRepo;
import com.download.util.HttpUtil;

@Service
public class ValidateUserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UrlRepo urlRepo;

    @Autowired
    ParameterRepo paramRepo;

    @Autowired
    PropertyRepo propertyRepo;

    public String validateUser(String user, String password, int chainId) {
        String htmlContent = "";
        String returnValue = "";
        boolean isValid = false;
        Url urlObj = urlRepo.findLoginUrl(chainId);
        if (urlObj != null) {
            password = decryptHeaderPassword(password, chainId);
            List<Parameter> paramList = paramRepo.findAllParametersFromUrl(urlObj.getUrlId());
            if (paramList != null) {
                HttpUtil.buildLoginUrl(user, password, urlObj.getUrlStr(), paramList);
                List<Property> propertiesList = propertyRepo.findAllPropertyFromUrl(urlObj.getUrlId());
                htmlContent = HttpUtil.getHtmlFromUrl(urlObj.getUrlStr(), propertiesList);
                switch (chainId) {
                    case 4:
                        isValid = ProvecomerUtil.isValidLogin(htmlContent);
                        break;
                }
                if (isValid) {
                    returnValue = JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, 0));
                } else {
                    returnValue = JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E003, 0));
                }
            } else {
                System.out.println("error obteniendo parametros");
            }
        } else {
            System.out.println("error en url de cadena id");
        }
        return returnValue;
    }

    public String decryptHeaderPassword(String pass, int chainId) {
        String decryptPass = null;
        switch (chainId) {
            case 4:
                decryptPass = ProvecomerUtil.decrypt(pass);
                break;
        }
        return decryptPass;
    }
}
