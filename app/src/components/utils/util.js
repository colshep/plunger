const util = {
    formatDate: function (date, format) {
        if (!format) {
            format = 'YYYY-MM-DD HH:mm:ss';
        }
        if (!date) {
            date = new Date();
        }
        let d = new Date(date)
        // 年
        if (/YYYY/.test(format)) {
            format = format.replace(/YYYY/, d.getFullYear())
        }
        // 月份
        let month = d.getMonth() + 1
        if (/MM/.test(format)) {
            let monthStr = month < 10 ? '0' + month : month
            format = format.replace(/MM/, monthStr)
        } else if (/M/.test(format)) {
            format = format.replace(/M/, month)
        }
        // 日期
        let dates = d.getDate()
        if (/DD/.test(format)) {
            let dateStr = dates < 10 ? '0' + dates : dates
            format = format.replace(/DD/, dateStr)
        } else if (/D/.test(format)) {
            format = format.replace(/D/, dates)
        }
        // 小时
        let hours = d.getHours()
        if (/HH/.test(format)) {
            let hoursStr = hours < 10 ? '0' + hours : hours
            format = format.replace(/HH/, hoursStr)
        } else if (/H/.test(format)) {
            format = format.replace(/H/, hours)
        } else if (/hh/.test(format)) {
            let hoursMin = hours > 12 ? hours - 12 : hours
            let hoursStr = hoursMin < 10 ? '0' + hoursMin : hoursMin
            format = format.replace(/hh/, hoursStr)
        } else if (/h/.test(format)) {
            let hoursMin = hours > 12 ? hours - 12 : hours
            format = format.replace(/h/, hoursMin)
        }
        // 分
        let minutes = d.getMinutes()
        if (/mm/.test(format)) {
            let minutesStr = minutes < 10 ? '0' + minutes : minutes
            format = format.replace(/mm/, minutesStr)
        } else if (/m/.test(format)) {
            format = format.replace(/m/, minutes)
        }
        // 秒
        let seconds = d.getSeconds()
        if (/ss/.test(format)) {
            let secondsStr = seconds < 10 ? '0' + seconds : seconds
            format = format.replace(/ss/, secondsStr)
        } else if (/s/.test(format)) {
            format = format.replace(/s/, seconds)
        }
        return format
    },
    findAreaNameByCode: function(areaArr, areaCode) {
        for (let i in areaArr) {
            if (areaArr[i].areaCode === areaCode) {
                return areaArr[i].areaName;
            }
        }
        return "";
    },
    uuid: function() {
        return 'xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            var r = Math.random() * 16 | 0,
                v = c == 'x' ? r : (r & 0x3 | 0x8);
            return v.toString(16);
        });
    },
    isMobile: function() {
        let flag = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i)
        return flag;
    },
    getFileType: function(fileExt) {
        const imgTypeList = ['jpg', 'jpeg', 'bmp', 'png', 'gif'];
        const videoTypeList = ['mp4', 'webm', 'ogg'];
        let fileType = 'file';
        if (imgTypeList.includes(fileExt)) {
            fileType = 'img';
        } else if (videoTypeList.includes(fileExt)) {
            fileType = 'video';
        }
        return fileType;
    }
}

export default util
