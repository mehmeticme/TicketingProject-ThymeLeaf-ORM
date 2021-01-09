package com.practice.converter;
import com.practice.dto.UserDTO;
import com.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDTOConverter implements Converter<String, UserDTO> {



    UserService userService;

    @Autowired
    public UserDTOConverter(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDTO convert(String source) {
        return userService.findByUserName(source);
    }
}
