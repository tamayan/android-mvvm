# Android MVVM Sample

## Directory

```tree
androidmvvm
├── data # データ源となるクラス郡
│   └── user
├── di # 依存関係を解決するクラス郡
│   └── user 
├── domain # アプリケーション全体の構造を表すクラス郡
│   └── user
└── presentation # UIに関するクラス郡
    └── user
```
## Library

- [Dagger2](https://github.com/google/dagger)
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [RxJava](https://github.com/ReactiveX/RxJava)
- [RxKotlin](https://github.com/ReactiveX/RxKotlin)
- [Retrofit2](https://github.com/square/retrofit)
- [Moshi](https://github.com/square/moshi)
- [Timber](https://github.com/JakeWharton/timber)

### Android Architecture Components

- [Handling Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Room](https://developer.android.com/topic/libraries/architecture/room)

### Android Support Libraries

- DataBinding
- Constraint Layout
- Appcompat v7
- Recyclerview v7

## API

webサーバーを建てて、サーバーから `user-list.json` を受け取れるようにしてください。

URLやBasic認証の情報を `gradle.properties` に追加してください。

例)Localでデバッグする場合

```gradle.properties
## local
local_base_url=http://localhost:8000/
local_user_name=Basic ID
local_password=Basic パスワード
```
