Add-Type -AssemblyName System.Drawing

$width = 512
$height = 512
$bmp = New-Object System.Drawing.Bitmap $width, $height
$g = [System.Drawing.Graphics]::FromImage($bmp)

$g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
$g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
$g.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::HighQuality
$g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::AntiAliasGridFit

# 1. Background Gradient (Deep Navy to Royal Blue with vibrant glow)
$bgRect = New-Object System.Drawing.Rectangle 0, 0, $width, $height
$bgBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 0, 0),
    (New-Object System.Drawing.Point $width, $height),
    [System.Drawing.Color]::FromArgb(255, 30, 58, 138),   # #1E3A8A Deep Blue
    [System.Drawing.Color]::FromArgb(255, 15, 23, 42)     # #0F172A Slate 900
)
$g.FillRectangle($bgBrush, $bgRect)
$bgBrush.Dispose()

# 2. Glowing Radial Ambient Spotlight (Center-top)
$spotPath = New-Object System.Drawing.Drawing2D.GraphicsPath
$spotPath.AddEllipse(36, 10, 440, 440)
$spotBrush = New-Object System.Drawing.Drawing2D.PathGradientBrush $spotPath
$spotBrush.CenterColor = [System.Drawing.Color]::FromArgb(120, 59, 130, 246) # Vibrant Sky Glow
$spotBrush.SurroundColors = @([System.Drawing.Color]::FromArgb(0, 30, 58, 138))
$g.FillPath($spotBrush, $spotPath)
$spotPath.Dispose()
$spotBrush.Dispose()

# 3. Outer Glowing Ring Frame
$penRing = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(35, 255, 255, 255), 2.5)
$g.DrawEllipse($penRing, 24, 24, 464, 464)
$penRing.Dispose()

# 4. Helper for Stars
$goldBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 0, 0),
    (New-Object System.Drawing.Point 50, 50),
    [System.Drawing.Color]::FromArgb(255, 251, 191, 36),  # Amber 400
    [System.Drawing.Color]::FromArgb(255, 217, 119, 6)    # Amber 600
)
$whiteBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(200, 255, 255, 255))

function DrawStar($gx, $cx, $cy, $r1, $r2, $brush) {
    $pts = New-Object System.Drawing.PointF[] 10
    for ($i = 0; $i -lt 10; $i++) {
        $r = if ($i % 2 -eq 0) { $r1 } else { $r2 }
        $angle = ($i * 36 - 90) * [Math]::PI / 180.0
        $pts[$i] = New-Object System.Drawing.PointF(($cx + $r * [Math]::Cos($angle)), ($cy + $r * [Math]::Sin($angle)))
    }
    $gx.FillPolygon($brush, $pts)
}

# Ambient twinkling stars
DrawStar $g 80 110 14 6 $goldBrush
DrawStar $g 430 110 14 6 $goldBrush
DrawStar $g 65 310 10 4 $whiteBrush
DrawStar $g 445 310 10 4 $goldBrush
DrawStar $g 256 50 26 11 $goldBrush # Crown Star

# 5. Open Book Illustration (Fixed paths, pure symmetry)
# Book cover backing / spine (Golden Amber border)
$coverPath = New-Object System.Drawing.Drawing2D.GraphicsPath
$coverPath.AddBezier(75, 275, 120, 298, 200, 318, 256, 305)
$coverPath.AddBezier(256, 305, 312, 318, 392, 298, 437, 275)
$coverPath.AddLine(437, 275, 437, 295)
$coverPath.AddBezier(437, 295, 392, 318, 312, 338, 256, 325)
$coverPath.AddBezier(256, 325, 200, 338, 120, 318, 75, 295)
$coverPath.CloseFigure()

$coverBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 75, 275),
    (New-Object System.Drawing.Point 437, 338),
    [System.Drawing.Color]::FromArgb(255, 245, 158, 11),
    [System.Drawing.Color]::FromArgb(255, 180, 83, 9)
)
$g.FillPath($coverBrush, $coverPath)
$coverBrush.Dispose()

# Left Page
$leftPage = New-Object System.Drawing.Drawing2D.GraphicsPath
$leftPage.AddBezier(256, 295, 205, 310, 130, 295, 85, 275)
$leftPage.AddLine(85, 275, 85, 195)
$leftPage.AddBezier(85, 195, 130, 215, 205, 230, 256, 215)
$leftPage.CloseFigure()

$pageBrushL = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 85, 195),
    (New-Object System.Drawing.Point 256, 295),
    [System.Drawing.Color]::FromArgb(255, 255, 255, 255),
    [System.Drawing.Color]::FromArgb(255, 226, 232, 240)
)
$g.FillPath($pageBrushL, $leftPage)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 203, 213, 225), 2)), $leftPage)
$pageBrushL.Dispose()

# Right Page
$rightPage = New-Object System.Drawing.Drawing2D.GraphicsPath
$rightPage.AddBezier(256, 295, 307, 310, 382, 295, 427, 275)
$rightPage.AddLine(427, 275, 427, 195)
$rightPage.AddBezier(427, 195, 382, 215, 307, 230, 256, 215)
$rightPage.CloseFigure()

$pageBrushR = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 256, 195),
    (New-Object System.Drawing.Point 427, 295),
    [System.Drawing.Color]::FromArgb(255, 248, 250, 252),
    [System.Drawing.Color]::FromArgb(255, 203, 213, 225)
)
$g.FillPath($pageBrushR, $rightPage)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 203, 213, 225), 2)), $rightPage)
$pageBrushR.Dispose()

# Faint lines inside pages representing knowledge / formulas
$penLine = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(80, 59, 130, 246), 2)
$g.DrawLine($penLine, 120, 230, 225, 243)
$g.DrawLine($penLine, 120, 250, 225, 263)
$g.DrawLine($penLine, 120, 270, 225, 283)

$g.DrawLine($penLine, 285, 243, 390, 230)
$g.DrawLine($penLine, 285, 263, 390, 250)
$g.DrawLine($penLine, 285, 283, 390, 270)
$penLine.Dispose()

# 6. Graduation Cap (Toga) Floating Above Book
# Diamond top
$capTop = New-Object System.Drawing.Drawing2D.GraphicsPath
$capTop.AddPolygon(@(
    (New-Object System.Drawing.PointF 256, 85),
    (New-Object System.Drawing.PointF 400, 135),
    (New-Object System.Drawing.PointF 256, 185),
    (New-Object System.Drawing.PointF 112, 135)
))
$capBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 112, 85),
    (New-Object System.Drawing.Point 400, 185),
    [System.Drawing.Color]::FromArgb(255, 59, 130, 246),  # Royal Blue
    [System.Drawing.Color]::FromArgb(255, 29, 78, 216)   # Deep Blue
)
$g.FillPath($capBrush, $capTop)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 147, 197, 253), 2.5)), $capTop)
$capBrush.Dispose()

# Skull cap under diamond
$capBase = New-Object System.Drawing.Drawing2D.GraphicsPath
$capBase.AddBezier(180, 162, 218, 196, 294, 196, 332, 162)
$capBase.AddLine(332, 162, 332, 184)
$capBase.AddBezier(332, 184, 294, 218, 218, 218, 180, 184)
$capBase.CloseFigure()
$capBaseBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 30, 58, 138))
$g.FillPath($capBaseBrush, $capBase)
$capBaseBrush.Dispose()

# Golden Tassel
$g.FillEllipse($goldBrush, 250, 130, 12, 12)
$tasselPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 245, 158, 11), 3.5)
$g.DrawBezier($tasselPen, 256, 136, 210, 130, 155, 155, 145, 195)
$g.FillEllipse($goldBrush, 139, 190, 13, 18)
$tasselPen.Dispose()

# 7. Brand Banner at Bottom: "EDUQUEST"
$bannerRect = New-Object System.Drawing.Rectangle 46, 360, 420, 68
$bannerPath = New-Object System.Drawing.Drawing2D.GraphicsPath
$r = 20
$bannerPath.AddArc($bannerRect.X, $bannerRect.Y, $r, $r, 180, 90)
$bannerPath.AddArc($bannerRect.Right - $r, $bannerRect.Y, $r, $r, 270, 90)
$bannerPath.AddArc($bannerRect.Right - $r, $bannerRect.Bottom - $r, $r, $r, 0, 90)
$bannerPath.AddArc($bannerRect.X, $bannerRect.Bottom - $r, $r, $r, 90, 90)
$bannerPath.CloseFigure()

$bannerBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 46, 360),
    (New-Object System.Drawing.Point 466, 428),
    [System.Drawing.Color]::FromArgb(255, 245, 158, 11), # Golden Amber
    [System.Drawing.Color]::FromArgb(255, 217, 119, 6)   # Deep Amber
)
$g.FillPath($bannerBrush, $bannerPath)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 254, 243, 199), 2)), $bannerPath)
$bannerBrush.Dispose()

# Text: "EDUQUEST"
$fontTitle = New-Object System.Drawing.Font("Arial", 32, [System.Drawing.FontStyle]::Bold)
$sf = New-Object System.Drawing.StringFormat
$sf.Alignment = [System.Drawing.StringAlignment]::Center
$sf.LineAlignment = [System.Drawing.StringAlignment]::Center

# Text Shadow & Main
$g.DrawString("EDUQUEST", $fontTitle, (New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(140, 120, 53, 15))), (New-Object System.Drawing.RectangleF 46, 363, 420, 68), $sf)
$g.DrawString("EDUQUEST", $fontTitle, (New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 255, 255, 255))), (New-Object System.Drawing.RectangleF 46, 360, 420, 68), $sf)
$fontTitle.Dispose()

# 8. Sub-pill: "SD • SMP • SMA"
$subPillRect = New-Object System.Drawing.Rectangle 126, 442, 260, 36
$subPath = New-Object System.Drawing.Drawing2D.GraphicsPath
$r2 = 18
$subPath.AddArc($subPillRect.X, $subPillRect.Y, $r2, $r2, 180, 90)
$subPath.AddArc($subPillRect.Right - $r2, $subPillRect.Y, $r2, $r2, 270, 90)
$subPath.AddArc($subPillRect.Right - $r2, $subPillRect.Bottom - $r2, $r2, $r2, 0, 90)
$subPath.AddArc($subPillRect.X, $subPillRect.Bottom - $r2, $r2, $r2, 90, 90)
$subPath.CloseFigure()

$subBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 30, 41, 59))
$g.FillPath($subBrush, $subPath)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 59, 130, 246), 1.5)), $subPath)
$subBrush.Dispose()

$fontSub = New-Object System.Drawing.Font("Arial", 13, [System.Drawing.FontStyle]::Bold)
$g.DrawString("SD  •  SMP  •  SMA", $fontSub, (New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 224, 231, 255))), (New-Object System.Drawing.RectangleF 126, 442, 260, 36), $sf)
$fontSub.Dispose()

# Save output
$outPath = "d:\Android\GameAnakSekolah\playstore_assets\logo_512.png"
$bmp.Save($outPath, [System.Drawing.Imaging.ImageFormat]::Png)

$artPath = "C:\Users\Asus\.gemini\antigravity\brain\804517ea-f646-4ddd-b05a-f5c1d99f9c48\logo_512.png"
Copy-Item $outPath $artPath -Force

$g.Dispose()
$bmp.Dispose()
Write-Host "Re-generated logo_512.png successfully!"