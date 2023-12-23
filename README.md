## 環境構築

`sdk env install`

## 以下実行しておく

```bash
sudo mkdir /mytmpfs/
sudo mount -t tmpfs tmpfs /mytmpfs
```

以下確認して、 /mytmpfsができてればOK
```bash
df -T
```