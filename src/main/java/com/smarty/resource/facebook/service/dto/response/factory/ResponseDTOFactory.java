package com.smarty.resource.facebook.service.dto.response.factory;

import com.smarty.resource.facebook.service.dto.engagment.ReactionDTO;
import com.smarty.resource.facebook.service.dto.response.impl.ErrorResponseDTO;
import com.smarty.resource.facebook.service.dto.response.impl.ReactionResponseDTO;
import com.smarty.resource.facebook.service.dto.response.impl.Response;
import com.smarty.resource.facebook.service.dto.response.impl.SuccesResponseDTO;
import org.springframework.http.HttpStatus;

public class ResponseDTOFactory
{

    public static Response getResponse(String status, Object data)
    {
	if (status.equals(FactoryConstants.SUCCESS))
	{
	    return new SuccesResponseDTO(HttpStatus.OK.value(), data);
	}
	if (status.equals(FactoryConstants.ERROR) && data instanceof String)
	{
	    return new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), data);
	} else if (status.equals(FactoryConstants.NO_DATA_AVAILABLE) && data instanceof String)
	{
	    return new ErrorResponseDTO(HttpStatus.NO_CONTENT.value(), data);
	} else if (status.equals(FactoryConstants.NOT_AUTHORIZED) && data instanceof String)
	{
	    return new ErrorResponseDTO(HttpStatus.UNAUTHORIZED.value(), data);
	} else if (status.equals(FactoryConstants.SOCIAL) && data instanceof ReactionDTO)
	{
	    ReactionDTO facebookReactionDTO = (ReactionDTO) data;
	    return new ReactionResponseDTO(HttpStatus.OK.value(), facebookReactionDTO);
	} else
	{
	    return null;
	}
    }
}
