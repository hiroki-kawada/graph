# graph

### Canvasを使用
- グラフを自作して表示するために「Canvas」を使用して表示する。

### 主に使用する処理
- drawCircle
  - 円を描画する際に使用する処理
    - color：表示する際の色
    - radius：円の半径
    - center：中心座標
    - alpha：不透明度
    - style：塗りつぶし指定
    - colorFilter：フィルター？(使用する機会がないので不明)
    - blendMode ：使用する機会がないので不明

- drawPath
  - 点と点を結びつけて図形を描画する処理
    - path：描画するための点の情報を保存してある変数
    - color：表示する際の色
    - alpha：不透明度
    - style：pathの部分を塗り潰すかの状態を変化
    - colorFilter：フィルター？(使用する機会がないので不明)
    - blendMode ：使用する機会がないので不明


- drawRect
  - 短形(四角)を描画する処理
    - color：表示する際の色
    - topLeft：描画開始位置
    - size：描画時の大きさ
    - alpha：不透明度
    - style：塗りつぶし指定
    - colorFilter：フィルター？(使用する機会がないので不明)
    - blendMode ：使用する機会がないので不明

- drawArc
  - 弧を描画する処理
    - color：表示する際の色
    - startAngle：開始角度を設定（0は３時を表しています。）
    - sweepAngle：startAngleに対して時計回りに描かれた円弧のサイズ
    - useCenter：円弧が境界の中心を閉じるかどうかを示すフラグ(true：中心を閉じる、false：開始角度、終了角度)
    - size：弧の寸法
    - topLeft：描画開始位置
    - alpha：不透明度
    - style：塗りつぶし指定
    - colorFilter：フィルター？(使用する機会がないので不明)
    - blendMode ：使用する機会がないので不明


- clipPath
  - 指定したpathを使用して描画領域をクリップするための処理
    - path：描画するための点の情報を保存してある変数
    - clipOp：指定された境界線でクリッピング操作を行う（基本的にClipOp.Intersectで問題なし）

