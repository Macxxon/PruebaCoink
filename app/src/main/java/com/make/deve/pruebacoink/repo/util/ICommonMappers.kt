package com.make.deve.pruebacoink.repo.util

/**
 * A common mapper interface, used to define de default behavior of a mapper and DI.
 */
interface Mapper<I, O> {
    fun map(input: I): O
}

/**
 * A common list mapper interface to define common list mappers.
 */
//region List mappers
// Non-nullable to Non-nullable
interface ListMapper<I, O> : Mapper<List<I>, List<O>>

// Nullable to Non-nullable
interface NullableInputListMapper<I, O> : Mapper<List<I>?, List<O>>

// Non-nullable to Nullable
interface NullableOutputListMapper<I, O> : Mapper<List<I>, List<O>?>

// Nullable to Nullable
interface NullableInputAndOutputListMapper<I, O> : Mapper<List<I>?, List<O>?>
//endregion