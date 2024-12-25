package com.example.demo.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	
	
	private String token;
	 public static class Builder {
	        private String token;

	        public Builder token(String token) {
	            this.token = token;
	            return this;
	        }

	        public AuthenticationResponse build() {
	            AuthenticationResponse response = new AuthenticationResponse();
	            response.token = this.token;
	            return response;
	        }
	    }

	    public static Builder builder() {
	        return new Builder();
	    }
	
}