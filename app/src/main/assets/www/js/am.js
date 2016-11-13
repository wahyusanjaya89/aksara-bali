function __am() {
    var n = {
        isDict: function (n) {
            var t = n + "";
            return -1 != t.indexOf(" Object")
        }, isDefined: function (n) {
            return "undefined" != n && null != n
        }, isString: function (n) {
            return "string" == typeof n
        }, isObject: function (n) {
            return "object" == typeof n
        }, isArray: function (n) {
            try {
                return n instanceof Array
            } catch (t) {
                return !1
            }
        }, isIn: function (n, t) {
            return t.indexOf(n) > -1
        }, $A: function (t) {
            return n.isArray(t) && !n.isString(t) ? t : t ? [t] : []
        }, map: function (n, t, e, r) {
            var i = 0, o = n.length;
            for (e && (i = e), r && (o = r), i; o > i; i++) {
                var u = t(n[i], i);
                if (void 0 != u)return u
            }
        }, update: function (n, t) {
            for (var e in t)n[e] = t[e];
            return n
        }, AEV: function (t, e, r) {
            t = n.$A(t), e = n.$A(e), n.map(t, function (t) {
                n.map(e, function (n) {
                    t.addEventListener(n, r)
                })
            })
        }, createDOM: function (t, e) {
            var r, i = 0, o = document.createElement(t), u = e[0];
            if (n.isDict(e[i])) {
                for (k in u)r = u[k], "style" == k || "s" == k ? o.style.cssText = r : "c" == k || "class" == k || "className" == k ? o.className = r : o.setAttribute(k, r);
                i++
            }
            null == u && (i = 1);
            for (var a = i; a < e.length; a++) {
                var r = e[a];
                if (r) {
                    var c = typeof r;
                    ("string" == c || "number" == c) && (r = n.TN(r)), o.appendChild(r)
                }
            }
            return o
        }, keys: function (n) {
            var t = [];
            for (var e in n)t.push(e);
            return t
        }, ACN: function (t) {
            return arguments.length < 2 || n.map(arguments, function (e) {
                n.isString(e) && (e = n.TN(e)), n.isDefined(e) && t.appendChild(e)
            }, 1), t
        }, swapDOM: function (n, t) {
            var e = n.parentNode;
            return t ? e.replaceChild(t, n) : e.removeChild(n), t
        }, RCN: function (t) {
            for (var e; e = t.firstChild;)n.swapDOM(e, null);
            return arguments.length < 2 ? t : n.ACN.apply(null, arguments)
        }, setStyle: function () {
            var t = Array.prototype.slice.call(arguments), e = t.pop(), r = ["top", "left", "right", "width", "height"];
            if (n.isObject(e))n.map(t, function (t) {
                n.map(n.keys(e), function (i) {
                    var o = e[i];
                    n.isIn(i, r) && (o = n.isString(o) && o || o + "px"), t.style[i] = o
                })
            }); else {
                var i = t.pop();
                n.map(t, function (t) {
                    n.isIn(i, r) && (e = n.isString(e) && e || e + "px"), t.style[i] = e
                })
            }
        }, nodeName: function (n) {
            return n.nodeName.toLowerCase()
        }, _nodeWalk: function (t, e, r, i) {
            var o, u = i(t);
            if ((o = e && r ? function (t) {
                    return n.nodeName(t) == e && n.hasClass(t, r)
                } : e ? function (t) {
                    return n.nodeName(t) == e
                } : function (t) {
                    return n.hasClass(t, r)
                })(t))return t;
            for (; u;) {
                if (o(u))return u;
                u = i(u)
            }
            return null
        }, getParentBytc: function (t, e, r) {
            return n._nodeWalk(t, e, r, function (n) {
                return n ? n.parentNode : void 0
            })
        }, getMousePos: function (n) {
            var t = 0, e = 0;
            if (!n)var n = window.event;
            return n.pageX || n.pageY ? (t = n.pageX, e = n.pageY) : (n.clientX || n.clientY) && (t = n.clientX + document.body.scrollLeft + document.documentElement.scrollLeft, e = n.clientY + document.body.scrollTop + document.documentElement.scrollTop), {
                x: t,
                y: e
            }
        }, e_stop: function (n) {
            n.stopPropagation ? n.stopPropagation() : n.cancelBubble = !0, n.preventDefault()
        }, REV: function (t, e, r) {
            t = n.$A(t), e = n.$A(e), n.map(t, function (t) {
                n.map(e, function (n) {
                    t.removeEventListener(n, r)
                })
            })
        }, $: function (n) {
            return document.getElementById(n)
        }
    };
    return function () {
        var t = "ul li td tr th tbody table input span b a div img button h1 video source h2 h3 h4 h5 h6 br hr textarea form p select option optgroup iframe script center dl dt dd small pre i label thead style canvas".split(" "), e = function (t) {
            n[t.toUpperCase()] = function () {
                return n.createDOM.apply(null, [t, arguments])
            }
        };
        n.map(t, e), n.TN = function (n) {
            return document.createTextNode(n)
        }
    }(), n
}
