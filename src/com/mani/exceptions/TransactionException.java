package com.mani.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/25/13
 * Time: 12:49 AM
 */
public class TransactionException extends Exception
{
	public TransactionException()
	{
		super();
	}

	public TransactionException(String message)
	{
		super(message);
	}

	public TransactionException(String message, Throwable object)
	{
		super(message, object);
	}

	public TransactionException(Throwable object)
	{
		super(object);
	}
}
