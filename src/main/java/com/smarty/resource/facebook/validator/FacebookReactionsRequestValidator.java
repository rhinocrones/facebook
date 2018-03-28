package com.smarty.resource.facebook.validator;

import com.smarty.resource.facebook.service.dto.request.ReactionsRequestDTO;
import com.smarty.resource.facebook.utils.constants.FacebookConstants;
import org.apache.commons.validator.routines.UrlValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FacebookReactionsRequestValidator implements ConstraintValidator<Validate, ReactionsRequestDTO>
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
    public boolean isValid(ReactionsRequestDTO reactionRequestDTO, ConstraintValidatorContext context)
    {
	boolean validPostId = true;
	boolean validReturnLimit = true;
	boolean validAppId = true;
	boolean validAppSecret = true;
	boolean validNextPage = true;
	boolean validReactionType = true;
	boolean validTopLevelOnly = true;
	if (reactionRequestDTO.getNextPageURL() != null)
	{
	    validNextPage = isValidNextPage(reactionRequestDTO);
	} else
	{
	    validPostId = isValidPostId(reactionRequestDTO);
	    validReturnLimit = isValidReturnLimit(reactionRequestDTO);
	    validAppId = isValidAppId(reactionRequestDTO);
	    validAppSecret = isValidAppSecret(reactionRequestDTO);
	    validReactionType = isValidReactionType(reactionRequestDTO);
	    validTopLevelOnly = isValidTopLevelOnly(reactionRequestDTO);
	}
	return validateAndFillUpErrorMesage(validNextPage, validPostId, validReturnLimit, validAppId, validAppSecret, validReactionType,
			validTopLevelOnly, context);
    }

    private boolean isValidNextPage(ReactionsRequestDTO reactionRequestDTO)
    {
	return new UrlValidator().isValid(reactionRequestDTO.getNextPageURL());
    }

    private boolean isValidPostId(ReactionsRequestDTO reactionRequestDTO)
    {
	return reactionRequestDTO.getPostId() != null && reactionRequestDTO.getPostId().matches(FacebookConstants.POST_ID);
    }

    private boolean isValidReturnLimit(ReactionsRequestDTO reactionRequestDTO)
    {
	return reactionRequestDTO.getReturnLimit() > FacebookConstants.ZERO && reactionRequestDTO.getReturnLimit() <= FacebookConstants.THOUSAND;
    }

    private boolean isValidAppId(ReactionsRequestDTO reactionRequestDTO)
    {
	return reactionRequestDTO.getAppId() != null && reactionRequestDTO.getAppId().length() == FacebookConstants.FIFTEEN && reactionRequestDTO
			.getAppId().matches(FacebookConstants.ONLY_DIGITS);
    }

    private boolean isValidAppSecret(ReactionsRequestDTO reactionRequestDTO)
    {
	return reactionRequestDTO.getAppSecret() != null && reactionRequestDTO.getAppSecret().length() == FacebookConstants.THIRTY_TWO
			&& reactionRequestDTO.getAppSecret().matches(FacebookConstants.LETTERS_AND_DIGITS);
    }

    private boolean isValidReactionType(ReactionsRequestDTO reactionRequestDTO)
    {
	return reactionRequestDTO.getReactionType() != null && (reactionRequestDTO.getReactionType().equalsIgnoreCase(FacebookConstants.COMMENTS)
			|| reactionRequestDTO.getReactionType().equalsIgnoreCase(FacebookConstants.LIKES));
    }

    private boolean isValidTopLevelOnly(ReactionsRequestDTO reactionRequestDTO)
    {
	return reactionRequestDTO.getReactionType() != null && !(reactionRequestDTO.getReactionType().equalsIgnoreCase(FacebookConstants.LIKES)
			&& reactionRequestDTO.isTopLevelOnly());
    }

    private boolean validateAndFillUpErrorMesage(boolean validNextPage, boolean validPostId, boolean validReturnLimit, boolean validAppId,
		    boolean validAppSecret, boolean validReactionType, boolean validTopLevelOnly, ConstraintValidatorContext context)
    {
	if (!validNextPage)
	{
	    fillUpErrorMessage(context, FacebookConstants.NEXT_PAGE_ERROR_MESSAGE, FacebookConstants.NEXT_PAGE_FIELD);
	}
	if (!validPostId)
	{
	    fillUpErrorMessage(context, FacebookConstants.POST_ID_ERROR_MESSAGE, FacebookConstants.POST_ID_FIELD);
	}
	if (!validReturnLimit)
	{
	    fillUpErrorMessage(context, FacebookConstants.RETURN_LIMIT_ERROR_MESSAGE, FacebookConstants.RETURN_LIMIT_FIELD);
	}
	if (!validAppId)
	{
	    fillUpErrorMessage(context, FacebookConstants.APP_ID_ERROR_MESSAGE, FacebookConstants.APP_ID_FIELD);
	}
	if (!validAppSecret)
	{
	    fillUpErrorMessage(context, FacebookConstants.APP_SECRET_ERROR_MESSAGE, FacebookConstants.APP_SECRET_FIELD);
	}
	if (!validReactionType)
	{
	    fillUpErrorMessage(context, FacebookConstants.REACTION_TYPE_ERROR_MESSAGE, FacebookConstants.REACTION_TYPE_FIELD);
	}
	if (!validTopLevelOnly)
	{
	    fillUpErrorMessage(context, FacebookConstants.TOP_LEVEL_ONLY_ERROR_MESSAGE, FacebookConstants.TOP_LEVEL_ONLY_TYPE_FIELD);
	}
	return validNextPage && validPostId && validReturnLimit && validAppId && validAppSecret && validReactionType && validTopLevelOnly;
    }

    private void fillUpErrorMessage(ConstraintValidatorContext context, String message, String field)
    {
	context.disableDefaultConstraintViolation();
	context.buildConstraintViolationWithTemplate(message).addPropertyNode(field).addConstraintViolation();
    }
}
