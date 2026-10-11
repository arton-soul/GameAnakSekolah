Add-Type -AssemblyName System.Drawing

$width = 1024
$height = 500
$bmp = New-Object System.Drawing.Bitmap $width, $height
$g = [System.Drawing.Graphics]::FromImage($bmp)

$g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
$g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
$g.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::HighQuality
$g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::AntiAliasGridFit

# 1. Background Gradient (Midnight Navy into Rich Royal Blue)
$bgRect = New-Object System.Drawing.Rectangle 0, 0, $width, $height
$bgBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 0, 0),
    (New-Object System.Drawing.Point $width, $height),
    [System.Drawing.Color]::FromArgb(255, 10, 17, 40),    # #0A1128
    [System.Drawing.Color]::FromArgb(255, 30, 58, 138)    # #1E3A8A
)
$g.FillRectangle($bgBrush, $bgRect)
$bgBrush.Dispose()

# 2. Ambient Glow Spheres
function DrawGlow($gx, $cx, $cy, $radius, $color, $alpha) {
    $path = New-Object System.Drawing.Drawing2D.GraphicsPath
    $path.AddEllipse($cx - $radius, $cy - $radius, $radius * 2, $radius * 2)
    $brush = New-Object System.Drawing.Drawing2D.PathGradientBrush $path
    $brush.CenterColor = [System.Drawing.Color]::FromArgb($alpha, $color.R, $color.G, $color.B)
    $brush.SurroundColors = @([System.Drawing.Color]::FromArgb(0, $color.R, $color.G, $color.B))
    $gx.FillPath($brush, $path)
    $path.Dispose()
    $brush.Dispose()
}

DrawGlow $g 820 250 320 ([System.Drawing.Color]::FromArgb(255, 59, 130, 246)) 90
DrawGlow $g 240 180 260 ([System.Drawing.Color]::FromArgb(255, 37, 99, 235)) 60
DrawGlow $g 830 190 190 ([System.Drawing.Color]::FromArgb(255, 245, 158, 11)) 50 # Golden warmth

# 3. Subtle Geometric Background Waves
$wavePen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(18, 255, 255, 255), 1.5)
for ($y = -100; $y -lt 600; $y += 70) {
    $g.DrawBezier($wavePen, 0, $y, 350, $y + 120, 700, $y - 80, 1024, $y + 60)
}
$wavePen.Dispose()

# 4. Helper for Stars & Particles
$goldBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 0, 0),
    (New-Object System.Drawing.Point 40, 40),
    [System.Drawing.Color]::FromArgb(255, 251, 191, 36),
    [System.Drawing.Color]::FromArgb(255, 217, 119, 6)
)
$whiteBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(220, 255, 255, 255))
$cyanBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(200, 56, 189, 248))

function DrawStar($gx, $cx, $cy, $r1, $r2, $brush) {
    $pts = New-Object System.Drawing.PointF[] 10
    for ($i = 0; $i -lt 10; $i++) {
        $r = if ($i % 2 -eq 0) { $r1 } else { $r2 }
        $angle = ($i * 36 - 90) * [Math]::PI / 180.0
        $pts[$i] = New-Object System.Drawing.PointF(($cx + $r * [Math]::Cos($angle)), ($cy + $r * [Math]::Sin($angle)))
    }
    $gx.FillPolygon($brush, $pts)
}

# Ambient stars
DrawStar $g 60 70 12 5 $goldBrush
DrawStar $g 490 55 10 4 $whiteBrush
DrawStar $g 980 80 14 6 $goldBrush
DrawStar $g 580 430 11 5 $cyanBrush
DrawStar $g 975 425 13 5 $goldBrush
DrawStar $g 420 370 8 3 $whiteBrush

# 5. LEFT SECTION: Typography & Badges

# A. Category Top Tag
$tagRect = New-Object System.Drawing.Rectangle 60, 48, 220, 32
$tagPath = New-Object System.Drawing.Drawing2D.GraphicsPath
$rTag = 16
$tagPath.AddArc($tagRect.X, $tagRect.Y, $rTag, $rTag, 180, 90)
$tagPath.AddArc($tagRect.Right - $rTag, $tagRect.Y, $rTag, $rTag, 270, 90)
$tagPath.AddArc($tagRect.Right - $rTag, $tagRect.Bottom - $rTag, $rTag, $rTag, 0, 90)
$tagPath.AddArc($tagRect.X, $tagRect.Bottom - $rTag, $rTag, $rTag, 90, 90)
$tagPath.CloseFigure()

$tagBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(210, 30, 41, 59))
$g.FillPath($tagBrush, $tagPath)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 245, 158, 11), 1.5)), $tagPath)

$fontTag = New-Object System.Drawing.Font("Arial", 11, [System.Drawing.FontStyle]::Bold)
$sfCenter = New-Object System.Drawing.StringFormat
$sfCenter.Alignment = [System.Drawing.StringAlignment]::Center
$sfCenter.LineAlignment = [System.Drawing.StringAlignment]::Center
$g.DrawString("GAME EDUKASI INDONESIA", $fontTag, (New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 251, 191, 36))), (New-Object System.Drawing.RectangleF 60, 48, 220, 32), $sfCenter)

# B. Main Title: "EDUQUEST"
$fontMain = New-Object System.Drawing.Font("Arial", 54, [System.Drawing.FontStyle]::Bold)
# Shadow
$g.DrawString("EDUQUEST", $fontMain, (New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(180, 0, 0, 0))), 63, 93)
# Gradient Text (White to Soft Cyan)
$titleBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point 60, 90),
    (New-Object System.Drawing.Point 420, 160),
    [System.Drawing.Color]::FromArgb(255, 255, 255, 255),
    [System.Drawing.Color]::FromArgb(255, 186, 230, 253)
)
$g.DrawString("EDUQUEST", $fontMain, $titleBrush, 60, 90)

# C. Subtitle Tagline (Clean, crisp, no overlapping)
$fontSub = New-Object System.Drawing.Font("Arial", 18, [System.Drawing.FontStyle]::Bold)
$g.DrawString("Petualangan Belajar & Ruang Ujian Sekolah", $fontSub, (New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 224, 231, 255))), 62, 172)

# D. Multi-Level Badges: SD • SMP • SMA
function DrawPill($gx, $x, $y, $w, $h, $bgColor, $borderColor, $textColor, $text) {
    $rect = New-Object System.Drawing.Rectangle $x, $y, $w, $h
    $path = New-Object System.Drawing.Drawing2D.GraphicsPath
    $rad = $h / 2
    $path.AddArc($rect.X, $rect.Y, $rad, $rad, 180, 90)
    $path.AddArc($rect.Right - $rad, $rect.Y, $rad, $rad, 270, 90)
    $path.AddArc($rect.Right - $rad, $rect.Bottom - $rad, $rad, $rad, 0, 90)
    $path.AddArc($rect.X, $rect.Bottom - $rad, $rad, $rad, 90, 90)
    $path.CloseFigure()
    
    $b = New-Object System.Drawing.SolidBrush $bgColor
    $gx.FillPath($b, $path)
    $p = New-Object System.Drawing.Pen $borderColor, 1.5
    $gx.DrawPath($p, $path)
    
    $f = New-Object System.Drawing.Font("Arial", 12, [System.Drawing.FontStyle]::Bold)
    $sf = New-Object System.Drawing.StringFormat
    $sf.Alignment = [System.Drawing.StringAlignment]::Center
    $sf.LineAlignment = [System.Drawing.StringAlignment]::Center
    $tb = New-Object System.Drawing.SolidBrush $textColor
    $gx.DrawString($text, $f, $tb, (New-Object System.Drawing.RectangleF $x, $y, $w, $h), $sf)
    
    $path.Dispose()
    $b.Dispose()
    $p.Dispose()
    $f.Dispose()
    $tb.Dispose()
}

# School Level Pills (Properly sized so text never wraps!)
DrawPill $g 62 218 135 36 ([System.Drawing.Color]::FromArgb(230, 220, 38, 38)) ([System.Drawing.Color]::FromArgb(255, 252, 165, 165)) ([System.Drawing.Color]::White) "SD (Kelas 1-6)"
DrawPill $g 207 218 145 36 ([System.Drawing.Color]::FromArgb(230, 217, 119, 6)) ([System.Drawing.Color]::FromArgb(255, 253, 230, 138)) ([System.Drawing.Color]::White) "SMP (Kelas 7-9)"
DrawPill $g 362 218 155 36 ([System.Drawing.Color]::FromArgb(230, 37, 99, 235)) ([System.Drawing.Color]::FromArgb(255, 191, 219, 254)) ([System.Drawing.Color]::White) "SMA (Kelas 10-12)"

# E. Feature Checkpoints
$fontFeat = New-Object System.Drawing.Font("Arial", 14, [System.Drawing.FontStyle]::Bold)
function DrawFeatureRow($gx, $x, $y, $title) {
    DrawStar $gx ($x + 10) ($y + 11) 11 5 $goldBrush
    $gx.DrawString($title, $fontFeat, (New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 255, 255, 255))), ($x + 30), ($y + 1))
}

DrawFeatureRow $g 62 282 "600 Soal Materi & Ujian Lengkap"
DrawFeatureRow $g 62 324 "Simulasi Tryout Terjadwal Berwaktu"
DrawFeatureRow $g 62 366 "100% Offline, Bebas Iklan & Kuota"
DrawFeatureRow $g 62 408 "Gamifikasi Seru: Misi, Koin, XP & Prestasi"

# Bottom Security / Curriculum Pill
DrawPill $g 62 450 430 34 ([System.Drawing.Color]::FromArgb(190, 15, 23, 42)) ([System.Drawing.Color]::FromArgb(255, 74, 222, 128)) ([System.Drawing.Color]::FromArgb(255, 74, 222, 128)) "✓ Sesuai Kurikulum Nasional • Aman & Ramah Privasi Anak"


# 6. RIGHT SECTION: Epic Scholastic Crest Illustration (Center at X=810, Y=245)
$cx = 810
$cy = 245

# A. Glowing Base Shield Card
$cardRect = New-Object System.Drawing.Rectangle ($cx - 165), ($cy - 165), 330, 335
$cardPath = New-Object System.Drawing.Drawing2D.GraphicsPath
$rCard = 26
$cardPath.AddArc($cardRect.X, $cardRect.Y, $rCard, $rCard, 180, 90)
$cardPath.AddArc($cardRect.Right - $rCard, $cardRect.Y, $rCard, $rCard, 270, 90)
$cardPath.AddArc($cardRect.Right - $rCard, $cardRect.Bottom - $rCard, $rCard, $rCard, 0, 90)
$cardPath.AddArc($cardRect.X, $cardRect.Bottom - $rCard, $rCard, $rCard, 90, 90)
$cardPath.CloseFigure()

$cardBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point ($cx - 165), ($cy - 165)),
    (New-Object System.Drawing.Point ($cx + 165), ($cy + 170)),
    [System.Drawing.Color]::FromArgb(210, 30, 58, 138),
    [System.Drawing.Color]::FromArgb(235, 15, 23, 42)
)
$g.FillPath($cardBrush, $cardPath)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(150, 147, 197, 253), 2)), $cardPath)
$cardBrush.Dispose()

# B. Open Knowledge Book inside Card
# Book Spine Base
$bSpine = New-Object System.Drawing.Drawing2D.GraphicsPath
$bSpine.AddBezier(($cx - 130), ($cy + 55), ($cx - 75), ($cy + 78), ($cx - 20), ($cy + 88), $cx, ($cy + 78))
$bSpine.AddBezier($cx, ($cy + 78), ($cx + 20), ($cy + 88), ($cx + 75), ($cy + 78), ($cx + 130), ($cy + 55))
$bSpine.AddLine(($cx + 130), ($cy + 55), ($cx + 130), ($cy + 70))
$bSpine.AddBezier(($cx + 130), ($cy + 70), ($cx + 75), ($cy + 92), ($cx + 20), ($cy + 102), $cx, ($cy + 92))
$bSpine.AddBezier($cx, ($cy + 92), ($cx - 20), ($cy + 102), ($cx - 75), ($cy + 92), ($cx - 130), ($cy + 70))
$bSpine.CloseFigure()
$g.FillPath($goldBrush, $bSpine)

# Book Left Page
$bLeft = New-Object System.Drawing.Drawing2D.GraphicsPath
$bLeft.AddBezier($cx, ($cy + 70), ($cx - 45), ($cy + 82), ($cx - 95), ($cy + 72), ($cx - 125), ($cy + 50))
$bLeft.AddLine(($cx - 125), ($cy + 50), ($cx - 125), ($cy - 12))
$bLeft.AddBezier(($cx - 125), ($cy - 12), ($cx - 95), ($cy + 8), ($cx - 45), ($cy + 18), $cx, ($cy + 5))
$bLeft.CloseFigure()
$bPageL = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point ($cx - 125), ($cy - 12)),
    (New-Object System.Drawing.Point $cx, ($cy + 70)),
    [System.Drawing.Color]::FromArgb(255, 255, 255, 255),
    [System.Drawing.Color]::FromArgb(255, 226, 232, 240)
)
$g.FillPath($bPageL, $bLeft)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 203, 213, 225), 2)), $bLeft)

# Book Right Page
$bRight = New-Object System.Drawing.Drawing2D.GraphicsPath
$bRight.AddBezier($cx, ($cy + 70), ($cx + 45), ($cy + 82), ($cx + 95), ($cy + 72), ($cx + 125), ($cy + 50))
$bRight.AddLine(($cx + 125), ($cy + 50), ($cx + 125), ($cy - 12))
$bRight.AddBezier(($cx + 125), ($cy - 12), ($cx + 95), ($cy + 8), ($cx + 45), ($cy + 18), $cx, ($cy + 5))
$bRight.CloseFigure()
$bPageR = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point $cx, ($cy - 12)),
    (New-Object System.Drawing.Point ($cx + 125), ($cy + 70)),
    [System.Drawing.Color]::FromArgb(255, 248, 250, 252),
    [System.Drawing.Color]::FromArgb(255, 203, 213, 225)
)
$g.FillPath($bPageR, $bRight)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 203, 213, 225), 2)), $bRight)

# Faint text lines on open book
$pLine = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(70, 37, 99, 235), 2)
$g.DrawLine($pLine, ($cx - 100), ($cy + 10), ($cx - 20), ($cy + 22))
$g.DrawLine($pLine, ($cx - 100), ($cy + 26), ($cx - 20), ($cy + 38))
$g.DrawLine($pLine, ($cx - 100), ($cy + 42), ($cx - 20), ($cy + 54))
$g.DrawLine($pLine, ($cx + 20), ($cy + 22), ($cx + 100), ($cy + 10))
$g.DrawLine($pLine, ($cx + 20), ($cy + 38), ($cx + 100), ($cy + 26))
$g.DrawLine($pLine, ($cx + 20), ($cy + 54), ($cx + 100), ($cy + 42))
$pLine.Dispose()

# C. Graduation Cap Floating above Book
$capDiamond = New-Object System.Drawing.Drawing2D.GraphicsPath
$capDiamond.AddPolygon(@(
    (New-Object System.Drawing.PointF $cx, ($cy - 110)),
    (New-Object System.Drawing.PointF ($cx + 110), ($cy - 72)),
    (New-Object System.Drawing.PointF $cx, ($cy - 34)),
    (New-Object System.Drawing.PointF ($cx - 110), ($cy - 72))
))
$capBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point ($cx - 110), ($cy - 110)),
    (New-Object System.Drawing.Point ($cx + 110), ($cy - 34)),
    [System.Drawing.Color]::FromArgb(255, 59, 130, 246),
    [System.Drawing.Color]::FromArgb(255, 29, 78, 216)
)
$g.FillPath($capBrush, $capDiamond)
$g.DrawPath((New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 147, 197, 253), 2.5)), $capDiamond)

# Cap Base
$cBase = New-Object System.Drawing.Drawing2D.GraphicsPath
$cBase.AddBezier(($cx - 55), ($cy - 52), ($cx - 28), ($cy - 30), ($cx + 28), ($cy - 30), ($cx + 55), ($cy - 52))
$cBase.AddLine(($cx + 55), ($cy - 52), ($cx + 55), ($cy - 36))
$cBase.AddBezier(($cx + 55), ($cy - 36), ($cx + 28), ($cy - 14), ($cx - 28), ($cy - 14), ($cx - 55), ($cy - 36))
$cBase.CloseFigure()
$g.FillPath((New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 30, 58, 138))), $cBase)

# Tassel & Button
$g.FillEllipse($goldBrush, ($cx - 6), ($cy - 78), 12, 12)
$tasPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255, 245, 158, 11), 3)
$g.DrawBezier($tasPen, $cx, ($cy - 72), ($cx - 35), ($cy - 78), ($cx - 75), ($cy - 58), ($cx - 85), ($cy - 30))
$g.FillEllipse($goldBrush, ($cx - 90), ($cy - 34), 12, 16)
$tasPen.Dispose()

# Top Star
DrawStar $g $cx ($cy - 135) 19 8 $goldBrush

# D. Trophy / Gamification Floating Badges on Card Corners
DrawPill $g ($cx - 140) ($cy + 115) 130 32 ([System.Drawing.Color]::FromArgb(255, 245, 158, 11)) ([System.Drawing.Color]::White) ([System.Drawing.Color]::FromArgb(255, 120, 53, 15)) "+500 XP"
DrawPill $g ($cx + 10) ($cy + 115) 130 32 ([System.Drawing.Color]::FromArgb(255, 16, 185, 129)) ([System.Drawing.Color]::White) ([System.Drawing.Color]::White) "Level Up!"

# Save
$outPath = "d:\Android\GameAnakSekolah\playstore_assets\feature_graphic_1024x500.png"
$bmp.Save($outPath, [System.Drawing.Imaging.ImageFormat]::Png)

$artPath = "C:\Users\Asus\.gemini\antigravity\brain\804517ea-f646-4ddd-b05a-f5c1d99f9c48\feature_graphic_1024x500.png"
Copy-Item $outPath $artPath -Force

$g.Dispose()
$bmp.Dispose()
Write-Host "Re-generated feature_graphic_1024x500.png successfully!"