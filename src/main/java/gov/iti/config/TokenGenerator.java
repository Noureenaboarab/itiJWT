package gov.iti.config;


import gov.iti.dto.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class TokenGenerator {

    @Autowired
    JwtEncoder accessTokenEncoder;


    private String createAccessToken(gov.iti.entity.User user) {
        Instant now = Instant.now();

        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("myApp")
                .issuedAt(now)
                .expiresAt(now.plus(10, ChronoUnit.MINUTES))
                .subject(String.valueOf(user.getUserId()))
                .claim("email", user.getEmail())
                .claim("roles", user.getRole().name())
                .claim("name", user.getUserName())
                .build();

        return accessTokenEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }

    public Token createToken(gov.iti.entity.User user) {

        Token tokenDTO = new Token();
        tokenDTO.setUserId(String.valueOf(user.getUserId()));
        tokenDTO.setAccessToken(createAccessToken(user));

        return tokenDTO;
    }

}