package view.service.use_case

interface LoadViewUseCase {

    fun <T : Any> loadView(clazz: Class<T>)
    fun returnToHomePage()
}