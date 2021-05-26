package com.andromoticaia.los10decolombia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andromoticaia.los10decolombia.domain.UseCase

class VMFactory(private val useCase: UseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(UseCase::class.java).newInstance(useCase)
    }
}