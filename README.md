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

## API

`local.properties` に追加してください。

```local.properties
# Release
release_base_url=
release_user_name=
release_password=
# Debug
debug_base_url=
debug_user_name=
debug_password=
# Local
local_base_url=http://192.168.10.106:3000/
local_user_name=
local_password=
```
