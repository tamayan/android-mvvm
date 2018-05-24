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
