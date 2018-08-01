# Android MVVM Sample

## Directory

```tree
androidmvvm
├── data # データ源となるクラス郡
│   ├── api
│   └── db
├── di # 依存関係を解決するクラス郡
│   └── user
├── domain # アプリケーション全体の構造を表すクラス郡
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

URLやBasic認証、Roomデータベースのファイル名を `local.properties` に追加してください。

例)Localでデバッグする場合

```local.properties
# buildTypes
## release
release_base_url=
release_user_name=
release_password=

## debug
debug_base_url=
debug_user_name=
debug_password=

## local
local_base_url=http://localhost:8080/
local_user_name=hoge
local_password=fuga

# Room Database
room_database_name=データベース名
```

## License

```LICENSE
Copyright 2018 tamayan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
