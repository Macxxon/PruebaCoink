package com.make.deve.pruebacoink.ui.registerFragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.make.deve.pruebacoink.repo.info.IInfoRepo
import com.make.deve.pruebacoink.repo.info.InfoUserModel
import com.make.deve.pruebacoink.ui.util.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class UserRegisterViewModel : BaseViewModel(), KoinComponent {

    val phoneNumber = MutableLiveData<String>()

    var newPhoneNumber = MutableLiveData<String>()
    var infoUserModel: InfoUserModel? = null

    val numPadListener = object : NumPadListener {
        override fun onNumberClicked(number: Char) {
            val existingNumber = phoneNumber.value ?: ""
            val validateDigits = existingNumber + number
            if(validateDigits.length < 10) {
                newPhoneNumber.value = existingNumber + number
                phoneNumber.postValue(newPhoneNumber.value)
            }

        }

        override fun onEraseClicked() {
            val droppedLast = newPhoneNumber.value?.dropLast(1) ?: ""
            newPhoneNumber.value = droppedLast
            val droppedLastPin = phoneNumber.value?.dropLast(1) ?: ""
            phoneNumber.postValue(droppedLastPin)

        }
    }

    val repo: IInfoRepo by inject()
    val listofDocTypes: MutableLiveData<GetDocTypesResponseModel> = MutableLiveData()
    val listofGenders: MutableLiveData<GetGendersResponseModel> = MutableLiveData()

    fun getDocTypes() {
        viewModelScope.launch {
            loading.value = true
            val rem = repo.getDocTypes()
            listofDocTypes.value = rem
            loading.value = false
        }
    }

    fun getGenders() {
        viewModelScope.launch {
            val rem = repo.getGenders()
            listofGenders.value = rem
        }
    }


}
