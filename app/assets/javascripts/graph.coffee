$ ->
  g = $("#graph")
  r = $("#reset")
  options = {
    xaxis: 
      { mode: "time"}
    selection:
      { mode: "x" }
  }  
  $.getJSON("/data", {} , (data) -> 
    g.plot(data, options).data("plot")
    g.bind("plotselected", (event, ranges) ->
      g.plot(data, $.extend(true, {}, options, {
        xaxis: { min: ranges.xaxis.from, max: ranges.xaxis.to }
      }))
    )
    r.click(->
      g.plot(data, options).data("plot")
    ))