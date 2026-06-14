# Figures Module 7

Java classes implementing geometric figures on the OXY plane.

## Package: `academy.tochkavhoda.figures.v1`

### Classes
- **Point** – a point with integer coordinates (provided)
- **Rectangle** – axis-aligned rectangle
- **Square** – axis-aligned square
- **Circle** – circle with integer center and radius
- **CircleFactory** – factory for creating Circle instances with a counter
- **Ellipse** – axis-aligned ellipse (xAxis and yAxis are full axis lengths)

## Building and Testing

```bash
# Compile
javac -cp junit-platform-console-standalone.jar -d target/classes src/main/java/**/*.java

# Run tests
java -jar junit-platform-console-standalone.jar \
  --class-path target/classes:target/test-classes \
  --scan-class-path
```

All 61 tests pass.
