package com.smarty.resource.facebook.validator;

import com.smarty.resource.facebook.service.dto.request.PostsRequestDTO;
import com.smarty.resource.facebook.utils.constants.FacebookConstants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class FacebookPostsRequestDTOValidator implements ConstraintValidator<Validate, PostsRequestDTO>
{

    /**
     * Initializes the validator in preparation for calls. The constraint
     * annotation for a given constraint declaration is passed. This method is
     * guaranteed to be called before any use of this instance for validation.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(Validate constraintAnnotation)
    {
	// No need to impl his method for our purpose
    }

    @Override
    public boolean isValid(PostsRequestDTO postsRequestDTO, ConstraintValidatorContext context)
    {
	boolean validPageId = isValidPageId(postsRequestDTO);
	boolean validDate = isValidDate(postsRequestDTO);
	boolean validAppId = isValidAppId(postsRequestDTO);
	boolean validAppSecret = isValidAppSecret(postsRequestDTO);
	boolean validReturnLimit = isValidReturnLimit(postsRequestDTO);
	return validateAndFillUpErrorMesage(validPageId, validDate, validAppId, validAppSecret, validReturnLimit, context);
    }

    private boolean isValidPageId(PostsRequestDTO requestFacebookDTO)
    {
	return requestFacebookDTO.getPageId() != null && requestFacebookDTO.getPageId().matches(FacebookConstants.ONLY_DIGITS);
    }

    private boolean isValidDate(PostsRequestDTO requestFacebookDTO)
    {
	return requestFacebookDTO.getEarliestPostingDate() == -1
			|| String.valueOf(new Date(requestFacebookDTO.getEarliestPostingDate()).getTime()).length() == FacebookConstants.THIRTEEN;
    }

    private boolean isValidAppId(PostsRequestDTO requestFacebookDTO)
    {
	return requestFacebookDTO.getAppId() != null && requestFacebookDTO.getAppId().length() == FacebookConstants.FIFTEEN && requestFacebookDTO
			.getAppId().matches(FacebookConstants.ONLY_DIGITS);
    }

    private boolean isValidAppSecret(PostsRequestDTO requestFacebookDTO)
    {
	return requestFacebookDTO.getAppSecret() != null && requestFacebookDTO.getAppSecret().length() == FacebookConstants.THIRTY_TWO
			&& requestFacebookDTO.getAppSecret().matches(FacebookConstants.LETTERS_AND_DIGITS);
    }

    private boolean isValidReturnLimit(PostsRequestDTO postsRequestDTO)
    {
	return postsRequestDTO.getReturnLimit() > FacebookConstants.ZERO && postsRequestDTO.getReturnLimit() <= FacebookConstants.ONE_HUNDRED;
    }

    private boolean validateAndFillUpErrorMesage(boolean validPageId, boolean validDate, boolean validAppId, boolean validAppSecret,
		    boolean validReturnLimit, ConstraintValidatorContext context)
    {
	if (!validPageId)
	{
	    fillUpErrorMessage(context, FacebookConstants.PAGE_ID_ERROR_MESSAGE, FacebookConstants.PAGE_ID_FIELD);
	}
	if (!validDate)
	{
	    fillUpErrorMessage(context, FacebookConstants.DATE_ERROR_MESSAGE, FacebookConstants.DATE_FIELD);
	}
	if (!validAppId)
	{
	    fillUpErrorMessage(context, FacebookConstants.APP_ID_ERROR_MESSAGE, FacebookConstants.APP_ID_FIELD);
	}
	if (!validAppSecret)
	{
	    fillUpErrorMessage(context, FacebookConstants.APP_SECRET_ERROR_MESSAGE, FacebookConstants.APP_SECRET_FIELD);
	}
	if (!validReturnLimit)
	{
	    fillUpErrorMessage(context, FacebookConstants.RETURN_LIMIT_POST_ERROR_MESSAGE, FacebookConstants.RETURN_LIMIT_FIELD);
	}
	return validPageId && validDate && validAppId && validAppSecret && validReturnLimit;
    }

    private void fillUpErrorMessage(ConstraintValidatorContext context, String message, String field)
    {
	context.disableDefaultConstraintViolation();
	context.buildConstraintViolationWithTemplate(message).addPropertyNode(field).addConstraintViolation();
    }
}
