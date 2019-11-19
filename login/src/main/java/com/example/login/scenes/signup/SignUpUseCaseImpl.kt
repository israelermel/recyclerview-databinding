package com.example.login.scenes.signup

class SignUpUseCaseImpl(private val signUpRepositoryImpl: SignUpRepositoryImpl) :
    BaseUseCase<SignUpUseCase.Result>(), SignUpUseCase {

    fun testeSucesso() {
//            signUpRepositoryImpl.teste()
        getLiveData().postValue(SignUpUseCase.Result.SignUpSuccess)
    }

    fun testeFalha() {
        getLiveData().postValue(SignUpUseCase.Result.OnSignUpError("falha conexao"))
    }
    /*
        No interactor extender do BaseUseCase que possui uma instancia do MultableLiveData
        e implementado outro interface que possui metodos para pegar essa instancia e cleanUp disposables

        No BaseUseCase passar como parametro <Login.Result> uma classe sealed class , ja que ela sera usada
        como return para os metodos usado no UseCase

        E no viewModel esses sealed class sera usado para mostrar os states dos campos
     */
}