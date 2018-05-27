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
