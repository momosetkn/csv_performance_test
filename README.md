# 実行前に確認

```bash
sudo mkdir /mytmpfs/
sudo mount -t tmpfs tmpfs /mytmpfs
```

以下確認して、 /mytmpfsができてればOK
```bash
df -T
```