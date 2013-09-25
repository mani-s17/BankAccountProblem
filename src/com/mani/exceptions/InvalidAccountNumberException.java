package com.mani.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/25/13
 * Time: 5:02 AM
 *
 * If user gives Invalid Account number for doing transaction then InvalidAccountNumberException will raise
 */
public class InvalidAccountNumberException extends Exception
{
	public InvalidAccountNumberException()
	{
		super();
	}

	public InvalidAccountNumberException(String message)
	{
		super(message);
	}

	public InvalidAccountNumberException(Throwable object)
	{
		super(object);
	}

	public InvalidAccountNumberException(String message, Throwable object)
	{
		super(message, object);
	}
}
